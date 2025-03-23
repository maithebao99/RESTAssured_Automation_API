package StepDefinitions.ObjectsAPISteps;

import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import Model.ObjectModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import Request.ObjectsAPI.GetObjectAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.HandleJson.JsonParser;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class GetObjectAPISteps {

    @Inject
    GetObjectAPI getObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    JsonParser jsonParser;

    @Inject
    ConvertToJson convertToJson;

    @Inject
    StatusCodeRequest statusCodeRequest;

    Response response;

    @Then("Receive data object when invoke api get object with id does exist")
    public void sendRequestGetObjectWithIDValid()
    {
        response = RestAssured.given().spec(getObjectAPI.initRequest()).when().get();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeRequest.getStatusCodeSuccess());
    }

    @And("Verify response data and body Get Object API")
    public void verifyResponseGetObject()
    {
        JSONArray jsonArrayResponse= convertToJson.convertResponseToJsonArray(response);
        if(!jsonArrayResponse.isEmpty())
        {
            JSONObject jsonResponse = jsonArrayResponse.getJSONObject(0);

            Map<String, Object> responseMap = new HashMap<>();
            jsonParser.parseJsonObjectToMap(jsonResponse, responseMap);

            Assert.assertEquals(objectModel.getBody(), responseMap);
        }
        else
        {
            Assert.assertTrue(jsonArrayResponse.isEmpty(), "ID object doesn't exist");
        }
    }

    @Then("Receive data object when invoke api get object with id doesn't exist is {string}")
    public void sendRequestGetObjectWithIDInvalid(String idObject)
    {
        response = RestAssured.given().spec(getObjectAPI.initRequest(idObject)).when().get();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeRequest.getStatusCodeSuccess());
    }
}
