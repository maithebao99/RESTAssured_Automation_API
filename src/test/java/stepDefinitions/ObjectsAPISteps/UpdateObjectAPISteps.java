package stepDefinitions.ObjectsAPISteps;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.ObjectModel;
import org.json.JSONObject;
import org.testng.Assert;
import request.objectsAPI.UpdateObjectAPI;
import utilities.HandleJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class UpdateObjectAPISteps {

    private final int statusCodeSuccess = 200;

    Response response;

    @Inject
    UpdateObjectAPI updateObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    HandleJson handleJson;

    @When("Data of object is updated when invoke api update object")
    public void sendRequestUpdateObject() throws IOException {
        Map<String, Object> mapBody= objectModel.getBody();
        JSONObject bodyJson = new JSONObject(mapBody);
        String id = objectModel.getId();

        response = RestAssured.given().spec(updateObjectAPI.initRequest(bodyJson, id)).when().put();
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);


        JSONObject reponseJson = handleJson.convertResponseToJsonObject(response);
        Map<String, Object> mapResponse = new HashMap<>();
        handleJson.parseJsonToMap(reponseJson, mapResponse);
        Assert.assertTrue(!mapBody.equals(mapResponse));
    }
}
