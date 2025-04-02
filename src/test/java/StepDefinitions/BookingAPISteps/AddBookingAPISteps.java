package StepDefinitions.BookingAPISteps;

import Model.BookingModel;
import Request.BookingAPI.AddBookingAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

import java.io.IOException;

@ScenarioScoped
public class AddBookingAPISteps {
    Response response;
    @Inject
    AddBookingAPI addBookingAPI;

    @Inject
    BookingModel bookingModel;

    RequestSpecification request;

    @Given("Set body {string} to Add Booking API")
    public void setBodyAddBooking(String body) throws IOException {
        request = RestAssured.given().spec(addBookingAPI.initRequestAddBooking(body));
    }

    @When("Add a new booking when invoke api add booking")
    public void sendRequestAddBooking() throws IOException {
        response = request.when().post();
        System.out.println(response.asPrettyString());

    }

    @Then("Verify response data and {int} Add Booking API")
    public void verifyResponseAddBooking(int statusCode)
    {
        Assert.assertEquals(response.statusCode(), statusCode);
        if(response.statusCode()== StatusCodeRequest.statusCodeSuccess)
        {
            JSONObject responseObject = ConvertToJson.convertResponseToJsonObject(response);
            int bookingID = responseObject.getInt("bookingid");
            bookingModel.setBookingID(bookingID);

            //Convert response to map
            JSONObject bookingValue = responseObject.getJSONObject("booking");
            JSONObject jsonBody = bookingModel.getBody();

            JSONAssert.assertEquals(jsonBody, bookingValue, false);
        }

    }
}
