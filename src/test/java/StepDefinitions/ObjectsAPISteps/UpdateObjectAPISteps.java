package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.UpdateObjectAPI;
import Utilities.JsonUtils;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

@ScenarioScoped
@Slf4j
public class UpdateObjectAPISteps {

    private Response response;

    @Inject
    private UpdateObjectAPI updateObjectAPI;

    @Inject
    private ObjectModel objectModel;

    @When("Data of object is updated when invoke api update object")
    public void sendRequestUpdateObject() {
        try {
            JSONObject jsonBody = objectModel.getBody();
            String id = objectModel.getId();

            if (jsonBody == null || id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Object body or ID is null/empty. Cannot proceed with update.");
            }

            response = RestAssured.given()
                    .spec(updateObjectAPI.initRequest(jsonBody, id))
                    .when()
                    .put();

            log.info("Response from update object API:\n{}", response.asPrettyString());

            Assert.assertEquals(
                    response.statusCode(),
                    StatusCodeRequest.statusCodeSuccess,
                    "Expected successful status code but got: " + response.statusCode()
            );

        } catch (Exception e) {
            log.error("Failed to update object via API", e);
            throw new RuntimeException("Update object API call failed.");
        }
    }

    @And("Verify response data is updated when invoke api update object")
    public void verifyResponseUpdateObject() {
        try {
            if (response == null) {
                throw new IllegalStateException("Response is null. Cannot verify.");
            }

            JSONObject responseJson = JsonUtils.convertResponseToJsonObject(response);
            Assert.assertFalse(responseJson.isEmpty(), "Response JSON is empty.");

            JSONObject expectedBody = objectModel.getBody();

            JSONAssert.assertEquals(expectedBody, responseJson, false);
            log.info("Response matches updated object body.");

        } catch (Exception e) {
            log.error("Failed to verify updated object response", e);
            throw new RuntimeException("Verification of updated object failed.");
        }
    }
}
