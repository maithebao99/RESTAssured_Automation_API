package Request.ObjectsAPI;

import Model.ObjectModel;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ScenarioScoped
public class DeleteObjectAPI {

    @Inject
    ObjectModel objectModel;

    // Create headers for the DELETE request
    private Map<String, String> prepareHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    // Initialize delete request using ID from ObjectModel
    public RequestSpecification initRequestDeleteObject() {
        String id = objectModel.getId();

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ObjectModel ID is null or empty.");
        }

        return buildRequest(id);
    }

    // Initialize delete request using provided ID
    public RequestSpecification initRequestDeleteObject(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Provided ID is null or empty.");
        }

        return buildRequest(id);
    }

    // Shared method to build the request
    private RequestSpecification buildRequest(String id) {
        try {
            log.info("Building DELETE request for object ID: {}", id);

            return new RequestSpecBuilder()
                    .setBaseUri(Path.baseObjectURL)
                    .setBasePath(Path.pathObject + "/" + id)
                    .addHeaders(prepareHeaders())
                    .build();

        } catch (Exception e) {
            log.error("Failed to build DELETE object request for ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to build request for deleting object with ID: " + id, e);
        }
    }
}
