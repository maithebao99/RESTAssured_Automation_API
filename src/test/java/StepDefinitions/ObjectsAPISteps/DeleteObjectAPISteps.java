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
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.Assert;

@ScenarioScoped
@Slf4j
public class DeleteObjectAPISteps {

    private Response response;

    @Inject
    DeleteObjectAPI deleteObjectAPI;

    @Inject
    ObjectModel objectModel;

    @When("Object is deleted when invoke api delete object api with id does exist")
    public void sendRequestDeleteObject() {
        try {
            response = RestAssured.given()
                    .spec(deleteObjectAPI.initRequestDeleteObject())
                    .when()
                    .delete();

            log.info("Response for valid ID:\n{}", response.asPrettyString());
        } catch (Exception e) {
            log.error("Failed to send DELETE request with existing ID", e);
            throw new RuntimeException("Failed to send DELETE request.");
        }
    }

    @Given("Invoke api delete object api with id doesn't exist is {string}")
    public void sendRequestDeleteObjectWithID(String id) {
        try {
            response = RestAssured.given()
                    .spec(deleteObjectAPI.initRequestDeleteObject(id))
                    .when()
                    .delete();

            objectModel.setInvalidId(id);
            log.info("Response for non-existing ID:\n{}", response.asPrettyString());

        } catch (Exception e) {
            log.error("Failed to send DELETE request with invalid ID", e);
            throw new RuntimeException("Failed to send DELETE request with non-existing ID.");
        }
    }

    @And("Verify response data after invoke delete object api")
    public void verifyResponseData() {
        try {
            if (response == null) {
                throw new IllegalStateException("Response is null. Cannot verify response.");
            }

            JSONObject jsonResponse = ConvertToJson.convertResponseToJsonObject(response);
            Assert.assertFalse(jsonResponse.isEmpty(), "JSON response is empty.");

            int statusCode = response.statusCode();

            if (statusCode == StatusCodeRequest.statusCodeSuccess) {
                String successMessage = jsonResponse.getString("message");
                Assert.assertEquals(successMessage,
                        "Object with id = " + objectModel.getId() + " has been deleted.");
                log.info("Object successfully deleted.");

            } else if (statusCode == StatusCodeRequest.statusCodeNotFound) {
                String errorMessage = jsonResponse.getString("error");
                Assert.assertEquals(errorMessage,
                        "Object with id = " + objectModel.getInvalidId() + " doesn't exist.");
                log.info("Object not found as expected.");

            } else {
                log.error("Unexpected status code: {}", statusCode);
                Assert.fail("Unexpected server response.");
            }

        } catch (Exception e) {
            log.error("Failed to verify DELETE response", e);
            throw new RuntimeException("DELETE API response verification failed.");
        }
    }
}
