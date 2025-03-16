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

import java.io.IOException;

@ScenarioScoped
public class AddObjectAPISteps {

    private final int statusCodeSuccess = 200;

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

    @When("Invoke api add object")
    public void sendRequestAddObject() throws IOException {
        response = request.when().post();
        System.out.printf(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);
    }

    @Then("Verify response data and body request Add Object API")
    public void verifyResponseData()
    {
        //Parse id from response and save id object to object model
        String idObject = response.jsonPath().getString("id");
        objectModel.setId(idObject);

        //Handle Response type Json Object to String Response
        String responseString = response.asString();

        //Chuyển response từ string sang jsonobject để handle parse json object từ response
        JSONObject jsonObjectResponse = new JSONObject(responseString);

        //Verify name of response
        if(objectModel.getName() != null)
        {
            Assert.assertTrue(jsonObjectResponse.has("name"));
            String nameFromResponse = response.jsonPath().getString("name");
            //Handle verify data between response and json body
            Assert.assertEquals(nameFromResponse, objectModel.getName());
        }
        else
        {
            Assert.assertTrue(jsonObjectResponse.isNull("name"));
        }

        //Verify data object of response
        if(objectModel.getDataObject() != null)
        {
            Assert.assertTrue(jsonObjectResponse.has("data"));
            JSONObject dataObjectFromResponse = jsonObjectResponse.getJSONObject("data");
            JSONAssert.assertEquals(dataObjectFromResponse, objectModel.getDataObject(), false);
        }
        else
        {
            Assert.assertTrue(jsonObjectResponse.isNull("data"));
        }
    }
}
