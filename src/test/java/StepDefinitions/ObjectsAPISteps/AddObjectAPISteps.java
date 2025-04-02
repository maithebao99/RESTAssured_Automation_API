package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.AddObjectAPI;
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
public class AddObjectAPISteps {

    @Inject
    AddObjectAPI addObjectAPI;

    @Inject
    ObjectModel objectModel;

    Response response;

    RequestSpecification request;

    @Given("Set body {string} to Add Object API")
    public void setBodyAddObjectAPI(String caseBody) throws IOException {
        request = RestAssured.given().spec(addObjectAPI.initRequest(caseBody));
    }

    @When("Create a new object when invoke api add object")
    public void sendRequestAddObject() throws IOException {
        response = request.when().post();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), StatusCodeRequest.statusCodeSuccess);
    }

    @Then("Verify response data and body Add Object API")
    public void verifyResponseData()
    {
        //Convert response to json object
        JSONObject jsonResponse = ConvertToJson.convertResponseToJsonObject(response);

        Assert.assertTrue(!jsonResponse.isEmpty());

        JSONObject jsonBody = objectModel.getBody();

        JSONAssert.assertEquals(jsonBody, jsonResponse, false);

        //Parse id from response and save id object to object model
        String idObject = jsonResponse.getString("id");
        objectModel.setId(idObject);

    }
}
