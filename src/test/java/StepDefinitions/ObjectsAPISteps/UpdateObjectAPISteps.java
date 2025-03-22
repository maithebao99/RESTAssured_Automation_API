package StepDefinitions.ObjectsAPISteps;

import Utilities.Constant;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import Model.ObjectModel;
import org.json.JSONObject;
import org.testng.Assert;
import Request.ObjectsAPI.UpdateObjectAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.HandleJson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class UpdateObjectAPISteps {

    Response response;

    @Inject
    UpdateObjectAPI updateObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    JsonParser jsonParser;

    @Inject
    Constant constant;

    @Inject
    ConvertToJson convertToJson;

    Map<String, Object> mapBody;

    @When("Data of object is updated when invoke api update object")
    public void sendRequestUpdateObject() throws IOException {
        mapBody= objectModel.getBody();
        JSONObject bodyJson = new JSONObject(mapBody);
        String id = objectModel.getId();

        response = RestAssured.given().spec(updateObjectAPI.initRequest(bodyJson, id)).when().put();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), constant.getStatusCodeSuccess());
    }

    @And("Verify response data is updated when invoke api update object")
    public void VerifyResponseUpdateObject()
    {
        mapBody= objectModel.getBody();
        JSONObject responseJson = convertToJson.convertResponseToJsonObject(response);
        Assert.assertTrue(!responseJson.isEmpty());
        Map<String, Object> mapResponse = new HashMap<>();
        jsonParser.parseJsonObjectToMap(responseJson, mapResponse);

        Assert.assertEquals(mapBody,mapResponse);
    }
}
