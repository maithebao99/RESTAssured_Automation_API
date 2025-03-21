package stepDefinitions.ObjectsAPISteps;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.ObjectModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import request.objectsAPI.GetObjectAPI;
import utilities.HandleJson;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class GetObjectAPISteps {

    private final int statusCodeSuccess= 200;

    @Inject
    GetObjectAPI getObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    HandleJson handleJson;

    Response response;

    @Then("Receive data object when invoke api get object")
    public void sendRequestGetObject()
    {
        response = RestAssured.given().spec(getObjectAPI.initRequest()).when().get();
        System.out.printf(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);
    }

    @And("Verify response data and body request Get Object API")
    public void verifyResponseGetObject()
    {
        String stringResponse = response.asString();
        JSONArray jsonArray= new JSONArray(stringResponse);
        JSONObject jsonResponse = jsonArray.getJSONObject(0);

        Assert.assertTrue(!handleJson.isJsonObjectEmpty(jsonResponse));

        Map<String, Object> responseMap = new HashMap<>();
        handleJson.parseJsonToMap(jsonResponse, responseMap);

        Assert.assertEquals(objectModel.getBody(), responseMap);
    }
}
