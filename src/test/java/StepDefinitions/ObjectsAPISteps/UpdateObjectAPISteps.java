package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.UpdateObjectAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

import java.io.IOException;

@ScenarioScoped
public class UpdateObjectAPISteps {

    Response response;

    @Inject
    UpdateObjectAPI updateObjectAPI;

    @Inject
    ObjectModel objectModel;

    @When("Data of object is updated when invoke api update object")
    public void sendRequestUpdateObject() throws IOException {
        JSONObject jsonBody= objectModel.getBody();
        String id = objectModel.getId();

        response = RestAssured.given().spec(updateObjectAPI.initRequest(jsonBody, id)).when().put();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), StatusCodeRequest.statusCodeSuccess);
    }

    @And("Verify response data is updated when invoke api update object")
    public void VerifyResponseUpdateObject()
    {
        JSONObject responseJson = ConvertToJson.convertResponseToJsonObject(response);
        Assert.assertTrue(!responseJson.isEmpty());

        JSONObject jsonBody = objectModel.getBody();
        JSONAssert.assertEquals(jsonBody, responseJson, false);
    }
}
