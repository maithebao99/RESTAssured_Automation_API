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

import java.io.IOException;

@ScenarioScoped
public class UpdateObjectAPISteps {

    private final int statusCodeSuccess = 200;

    Response response;

    @Inject
    UpdateObjectAPI updateObjectAPI;

    @Inject
    ObjectModel objectModel;

    @When("Data of object is updated when invoke api update object")
    public void sendRequestUpdateObject() throws IOException {
        JSONObject body = objectModel.getResponse();
        String id = objectModel.getId();

        response = RestAssured.given().spec(updateObjectAPI.initRequest(body, id)).when().put();
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);
    }
}
