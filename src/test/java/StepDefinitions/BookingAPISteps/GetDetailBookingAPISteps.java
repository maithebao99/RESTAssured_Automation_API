package StepDefinitions.BookingAPISteps;

import Model.BookingModel;
import Request.BookingAPI.GetDetailBookingAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

@Slf4j
@ScenarioScoped
public class GetDetailBookingAPISteps {

    private Response response;

    @Inject
    private GetDetailBookingAPI getDetailBookingAPI;

    @Inject
    private BookingModel bookingModel;

    @Then("Receive data detail booking when invoke api get detail booking")
    public void sendRequestGetDetailBooking() {
        try {
            response = RestAssured.given()
                    .spec(getDetailBookingAPI.initRequestGetDetailBooking())
                    .when()
                    .get();

            log.info("Received response:\n{}", response.asPrettyString());

        } catch (Exception e) {
            log.error("Failed to send GET request for booking details: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to get detail booking.");
        }
    }

    @And("Verify response data detail booking and with status code is {int}")
    public void verifyResponseDataDetailBooking(int code) {
        try {
            Assert.assertEquals(response.statusCode(), code,
                    "Expected status code " + code + " but got " + response.statusCode());

            if (response.statusCode() == StatusCodeRequest.statusCodeSuccess) {
                JSONObject responseObject = ConvertToJson.convertResponseToJsonObject(response);
                JSONObject expectedBody = bookingModel.getBody();

                JSONAssert.assertEquals(expectedBody, responseObject, false);
                log.info("Response matches expected booking details.");
            }

        } catch (Exception e) {
            log.error("Failed to verify booking detail response: {}", e.getMessage(), e);
            throw new RuntimeException("Verification failed for booking details.");
        }
    }
}
