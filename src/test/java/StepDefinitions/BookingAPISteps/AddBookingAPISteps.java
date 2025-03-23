package StepDefinitions.BookingAPISteps;

import Model.BookingModel;
import Request.BookingAPI.AddBookingAPI;
import Utilities.StatusCodeRequest;
import Utilities.HandleJson.ConvertToJson;
import Utilities.HandleJson.JsonParser;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class AddBookingAPISteps {
    Response response;
    @Inject
    AddBookingAPI addBookingAPI;

    @Inject
    StatusCodeRequest statusCodeRequest;

    @Inject
    JsonParser jsonParser;

    @Inject
    ConvertToJson convertToJson;

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
        if(response.statusCode()== this.statusCodeRequest.getStatusCodeSuccess())
        {
            JSONObject responseObject = convertToJson.convertResponseToJsonObject(response);
            int bookingID = responseObject.getInt("bookingid");
            bookingModel.setBookingID(bookingID);

            //Convert response to map
            JSONObject bookingValue = responseObject.getJSONObject("booking");
            Map<String, Object> bookingValueMap = new HashMap<>();
            jsonParser.parseJsonObjectToMap(bookingValue, bookingValueMap);

            Map<String, Object> bodyMap = bookingModel.getBody();
            Assert.assertEquals(bodyMap,bookingValueMap);
        }

    }
}
