package Request.ObjectsAPI;

import Model.ObjectModel;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ScenarioScoped
public class UpdateObjectAPI {

    @Inject
    ObjectModel objectModel;

    // Prepare headers
    private Map<String, String> prepareHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "*/*");
        return headers;
    }

    // Recursively change all values except for createdAt
    private void changeValues(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            if ("createdAt".equals(key)) continue;

            if (value instanceof JSONObject) {
                changeValues((JSONObject) value); // Recurse for nested JSON
            } else {
                jsonObject.put(key, "Updated Value"); // Replace value
            }
        }
    }

    public RequestSpecification initRequest(JSONObject bodyJsonObject, String id) {
        try {
            if (bodyJsonObject == null || id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Request body or ID must not be null or empty.");
            }

            log.info("Preparing update request for object ID: {}", id);

            changeValues(bodyJsonObject);
            String updatedBody = bodyJsonObject.toString();

            objectModel.setBody(bodyJsonObject); // Save updated body

            return new RequestSpecBuilder()
                    .setBaseUri(Path.baseObjectURL)
                    .setBasePath(Path.pathObject + "/" + id)
                    .addHeaders(prepareHeaders())
                    .setBody(updatedBody)
                    .build();

        } catch (Exception e) {
            log.error("Failed to initialize UPDATE object request for ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to build update request for ID: " + id, e);
        }
    }
}
