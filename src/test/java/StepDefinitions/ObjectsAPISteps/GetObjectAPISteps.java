package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.GetObjectAPI;
import Utilities.HandleJson.ConvertToJson;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

@ScenarioScoped
@Slf4j
public class GetObjectAPISteps {

    @Inject
    GetObjectAPI getObjectAPI;

    @Inject
    ObjectModel objectModel;

    private Response response;

    @Then("Receive data object when invoke api get object with id does exist")
    public void sendRequestGetObjectWithIDValid() {
        try {
            response = RestAssured.given()
                    .spec(getObjectAPI.initRequest())
                    .when()
                    .get();

            log.info("Response for existing ID:\n{}", response.asPrettyString());
            Assert.assertEquals(response.statusCode(), StatusCodeRequest.statusCodeSuccess);

        } catch (Exception e) {
            log.error("Failed to get object with existing ID", e);
            throw new RuntimeException("Failed to send GET request for valid object ID.");
        }
    }

    @And("Verify response data and body Get Object API")
    public void verifyResponseGetObject() {
        try {
            if (response == null) {
                throw new IllegalStateException("Response is null. Cannot verify response.");
            }

            JSONArray jsonArrayResponse = ConvertToJson.convertResponseToJsonArray(response);
            Assert.assertNotNull(jsonArrayResponse, "Response array is null.");

            if (!jsonArrayResponse.isEmpty()) {
                JSONObject jsonResponse = jsonArrayResponse.getJSONObject(0);
                JSONObject jsonBody = objectModel.getBody();

                JSONAssert.assertEquals(jsonBody, jsonResponse, false);
                log.info("Response matches expected body.");
            } else {
                Assert.fail("Response JSON array is empty. Possibly invalid or missing object.");
            }

        } catch (Exception e) {
            log.error("Failed to verify GET object response", e);
            throw new RuntimeException("GET object response verification failed.");
        }
    }

    @Then("Receive data object when invoke api get object with id doesn't exist is {string}")
    public void sendRequestGetObjectWithIDInvalid(String idObject) {
        try {
            response = RestAssured.given()
                    .spec(getObjectAPI.initRequest(idObject))
                    .when()
                    .get();

            log.info("Response for invalid ID:\n{}", response.asPrettyString());
            Assert.assertEquals(response.statusCode(), StatusCodeRequest.statusCodeSuccess);

        } catch (Exception e) {
            log.error("Failed to get object with invalid ID", e);
            throw new RuntimeException("Failed to send GET request for invalid object ID.");
        }
    }

    @And("Verify response data Get Object API with id is invalid")
    public void verifyResponseGetObjectWithIdInvalid() {
        try {
            if (response == null) {
                throw new IllegalStateException("Response is null. Cannot verify response.");
            }

            JSONArray jsonArrayResponse = ConvertToJson.convertResponseToJsonArray(response);
            Assert.assertNotNull(jsonArrayResponse, "Response array is null.");

            if (jsonArrayResponse.isEmpty()) {
                Assert.assertTrue(jsonArrayResponse.isEmpty(), "Response is empty because ID is invalid");
                log.info("Empty response received as expected for invalid ID.");
            } else {
                Assert.fail("ID is invalid but response is not empty.");
            }

        } catch (Exception e) {
            log.error("Failed to verify GET object response for invalid ID", e);
            throw new RuntimeException("GET object response verification failed.");
        }
    }
}
