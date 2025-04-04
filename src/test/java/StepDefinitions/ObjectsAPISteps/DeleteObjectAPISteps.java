package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.DeleteObjectAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

@ScenarioScoped
public class DeleteObjectAPISteps {

    private Response response;

    @Inject
    DeleteObjectAPI deleteObjectAPI;


    @Inject
    ObjectModel objectModel;

    @When("Object is deleted when invoke api delete object api with id does exist")
    public void sendRequestDeleteObject()
    {
        response = RestAssured.given().spec(deleteObjectAPI.initRequestDeleteObject()).when().delete();
        System.out.printf(response.asPrettyString());
    }

    @Given("Invoke api delete object api with id doesn't exist is {string}")
    public void sendRequestDeleteObjectWithID(String id)
    {
        response = RestAssured.given().spec(deleteObjectAPI.initRequestDeleteObject(id)).when().delete();
        objectModel.setInvalidId(id);
        System.out.println(response.asPrettyString());
    }

    @And("Verify response data after invoke delete object api")
    public void verifyResponseData()
    {
        JSONObject jsonResponse = ConvertToJson.convertResponseToJsonObject(response);
        Assert.assertTrue(!jsonResponse.isEmpty());

        if(response.statusCode() == StatusCodeRequest.statusCodeSuccess)
        {
            String messageSuccess = jsonResponse.getString("message");
            Assert.assertEquals(messageSuccess, "Object with id = " + objectModel.getId() +" has been deleted.");
        }
        else if(response.statusCode() == StatusCodeRequest.statusCodeNotFound)
        {
            String error = jsonResponse.getString("error");
            Assert.assertEquals(error, "Object with id = " + objectModel.getInvalidId() +" doesn't exist.");
        }
        else
        {
            Assert.fail("Server is not working");
        }
    }
}
