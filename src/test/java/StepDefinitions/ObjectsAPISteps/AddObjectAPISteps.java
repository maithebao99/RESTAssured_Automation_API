package StepDefinitions.ObjectsAPISteps;

import Model.ObjectModel;
import Request.ObjectsAPI.AddObjectAPI;
import Utilities.JsonUtils;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;

@ScenarioScoped
@Slf4j
public class AddObjectAPISteps {

    @Inject
    AddObjectAPI addObjectAPI;

    @Inject
    ObjectModel objectModel;

    private Response response;
    private RequestSpecification request;

    @Given("Set body {string} to Add Object API")
    public void setBodyAddObjectAPI(String caseBody) {
        try {
            request = RestAssured.given().spec(addObjectAPI.initRequest(caseBody));
            log.info("Request initialized for case: {}", caseBody);
        } catch (Exception e) {
            log.error("Failed to set body for Add Object API - case: {}", caseBody, e);
            throw new RuntimeException("Unable to initialize request for Add Object API.");
        }
    }

    @When("Create a new object when invoke api add object")
    public void sendRequestAddObject() {
        try {
            if (request == null) {
                throw new IllegalStateException("Request is not initialized.");
            }

            response = request.when().post();
            log.info("Response received:\n{}", response.asPrettyString());

            Assert.assertEquals(
                    response.statusCode(),
                    StatusCodeRequest.statusCodeSuccess,
                    "Expected status code " + StatusCodeRequest.statusCodeSuccess
            );
        } catch (Exception e) {
            log.error("Failed to send Add Object API request", e);
            throw new RuntimeException("POST request to Add Object API failed.");
        }
    }

    @Then("Verify response data and body Add Object API")
    public void verifyResponseData() {
        try {
            if (response == null) {
                throw new IllegalStateException("Response is null. Cannot verify.");
            }

            JSONObject jsonResponse = JsonUtils.convertResponseToJsonObject(response);
            Assert.assertFalse(jsonResponse.isEmpty(), "Response is empty.");

            JSONObject expectedBody = objectModel.getBody();
            JSONAssert.assertEquals(expectedBody, jsonResponse, false);

            String idObject = jsonResponse.getString("id");
            objectModel.setId(idObject);

            log.info("Object created successfully with ID: {}", idObject);

        } catch (Exception e) {
            log.error("Failed to verify Add Object API response", e);
            throw new RuntimeException("Response verification failed.");
        }
    }
}
