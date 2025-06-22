package StepDefinitions.BookingAPISteps;

import Model.BookingModel;
import Request.BookingAPI.AddBookingAPI;
import Utilities.JsonUtils;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

@Slf4j
@ScenarioScoped
public class AddBookingAPISteps {

    private Response response;
    private RequestSpecification request;

    @Inject
    private AddBookingAPI addBookingAPI;

    @Inject
    private BookingModel bookingModel;

    @Given("Set body {string} to Add Booking API")
    public void setBodyAddBooking(String body) {
        try {
            request = RestAssured.given().spec(addBookingAPI.initRequestAddBooking(body));
            log.info("Initialized Add Booking request with body case: {}", body);
        } catch (Exception e) {
            log.error("Failed to initialize Add Booking request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to set body for Add Booking API.");
        }
    }

    @When("Add a new booking when invoke api add booking")
    public void sendRequestAddBooking() {
        try {
            response = request.when().post();
            log.info("Received response:\n{}", response.asPrettyString());
        } catch (Exception e) {
            log.error("Failed to send Add Booking API request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send POST request for Add Booking API.");
        }
    }

    @Then("Verify response data and {int} Add Booking API")
    public void verifyResponseAddBooking(int statusCode) {
        try {
            Assert.assertEquals(response.statusCode(), statusCode,
                    "Expected status code " + statusCode + " but got " + response.statusCode());

            if (response.statusCode() == StatusCodeRequest.statusCodeSuccess) {
                JSONObject responseObject = JsonUtils.convertResponseToJsonObject(response);
                int bookingID = responseObject.getInt("bookingid");
                bookingModel.setBookingID(bookingID);

                JSONObject bookingValue = responseObject.getJSONObject("booking");
                JSONObject jsonBody = bookingModel.getBody();

                JSONAssert.assertEquals(jsonBody, bookingValue, false);
                log.info("Booking created successfully with ID: {}", bookingID);
            }

        } catch (Exception e) {
            log.error("Verification failed for Add Booking API response: {}", e.getMessage(), e);
            throw new RuntimeException("Response verification failed for Add Booking API.");
        }
    }
}
