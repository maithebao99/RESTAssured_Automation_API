package stepDefinitions.ObjectsAPISteps;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ObjectModel;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import request.objectsAPI.AddObjectAPI;
import utilities.HandleJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class AddObjectAPISteps {

    private final int statusCodeSuccess = 200;

    @Inject
    AddObjectAPI addObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    HandleJson handleJson;

    Response response;

    RequestSpecification request;

    @Given("Set body {string} to Add Object API")
    public void setBodyAddObjectAPI(String caseBody) throws IOException {
        request = RestAssured.given().spec(addObjectAPI.initRequest(caseBody));
    }

    @When("Create a new object when invoke api add object")
    public void sendRequestAddObject() throws IOException {
        response = request.when().post();
        System.out.printf(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);

    }

    @Then("Verify response data and body request Add Object API")
    public void verifyResponseData()
    {
        //Convert response to json object
        String stringResponse = response.asString();
        JSONObject jsonResponse = new JSONObject(stringResponse);

        Assert.assertTrue(!handleJson.isJsonObjectEmpty(jsonResponse));

        Map<String, Object> responseMap = new HashMap<>();
        handleJson.parseJsonToMap(jsonResponse, responseMap);
        //Save respone to object model
        objectModel.setResponse(responseMap);

        Assert.assertEquals(responseMap, objectModel.getResponse());

        //Parse id from response and save id object to object model
        Object idObject = responseMap.get("id");
        objectModel.setId(idObject.toString());

    }
}
