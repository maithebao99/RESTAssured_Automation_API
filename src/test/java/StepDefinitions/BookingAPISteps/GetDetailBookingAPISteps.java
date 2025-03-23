package StepDefinitions.BookingAPISteps;

import Model.BookingModel;
import Request.BookingAPI.GetDetailBookingAPI;
import Utilities.StatusCodeRequest;
import Utilities.HandleJson.ConvertToJson;
import Utilities.HandleJson.JsonParser;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class GetDetailBookingAPISteps {
    Response response;

    @Inject
    GetDetailBookingAPI getDetailBookingAPI;

    @Inject
    ConvertToJson convertToJson;

    @Inject
    JsonParser jsonParser;

    @Inject
    BookingModel bookingModel;

    @Inject
    StatusCodeRequest statusCodeRequest;

    @Then("Receive data detail booking when invoke api get detail booking")
    public void sendRequestGetDetailBooking()
    {
        response = RestAssured.given().spec(getDetailBookingAPI.initRequestGetDetailBooking()).when().get();
        System.out.println(response.asPrettyString());
    }

    @And("Verify response data detail booking and with status code is {int}")
    public void verifyResponseDataDetailBooking(int code)
    {
        Assert.assertEquals(response.statusCode(), code);
        if(response.statusCode() == statusCodeRequest.getStatusCodeSuccess())
        {
            JSONObject responseObject = convertToJson.convertResponseToJsonObject(response);
            Map<String, Object> responseBooking = new HashMap<>();
            jsonParser.parseJsonObjectToMap(responseObject, responseBooking);

            Map<String, Object> bodyBooking = bookingModel.getBody();
            Assert.assertEquals(bodyBooking,  responseBooking);
        }
    }
}
