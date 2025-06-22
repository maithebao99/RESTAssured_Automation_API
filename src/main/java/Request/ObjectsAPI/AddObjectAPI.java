package Request.ObjectsAPI;

import Model.ObjectModel;
import Utilities.FileUtils;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@Setter
@ScenarioScoped
public class AddObjectAPI {

    @Inject
    ObjectModel objectModel;

    public RequestSpecification request;

    // Prepare request body for a given case name
    private String prepareBody(String caseBody) {
        try {
            File file = new File("TestSuites/Data/ObjectsData/bodyAddObject.json");
            log.info("Reading request body from file: {}", file.getPath());

            JSONObject jsonObject = FileUtils.readFileToJsonObject(file, StandardCharsets.UTF_8);

            if (!jsonObject.has(caseBody)) {
                throw new IllegalArgumentException("Key '" + caseBody + "' not found in bodyAddObject.json");
            }

            JSONObject bodyJsonObject = jsonObject.getJSONObject(caseBody);
            objectModel.setBody(bodyJsonObject);  // Store in model

            log.info("Prepared request body for case '{}': {}", caseBody, bodyJsonObject.toString());

            return bodyJsonObject.toString();

        } catch (IOException e) {
            log.error("Failed to read JSON file for AddObjectAPI: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Failed to prepare request body for case '{}': {}", caseBody, e.getMessage(), e);
        }

        return null;
    }

    // Prepare default headers
    private Map<String, String> prepareHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("accept", "application/json");
        return headers;
    }

    public RequestSpecification initRequest(String caseBody) {
        String requestBody = prepareBody(caseBody);
        Map<String, String> headers = prepareHeaders();

        if (requestBody == null) {
            throw new IllegalStateException("Request body is null, cannot initialize request.");
        }

        log.info("Initializing AddObjectAPI request for case: {}", caseBody);

        request = new RequestSpecBuilder()
                .setBaseUri(Path.baseObjectURL)
                .setBasePath(Path.pathObject)
                .setBody(requestBody)
                .addHeaders(headers)
                .build();

        return request;
    }
}
