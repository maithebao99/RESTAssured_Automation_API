package Request.ObjectsAPI;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import Model.ObjectModel;
import Utilities.Path;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ScenarioScoped
public class GetObjectAPI {

    @Inject
    ObjectModel objectModel;

    // Prepare headers
    private Map<String, String> prepareHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }

    // Prepare query parameters
    private Map<String, String> prepareParams(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return params;
    }

    // Init GET request using ObjectModel ID
    public RequestSpecification initRequest() {
        String id = objectModel.getId();
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ObjectModel ID is null or empty.");
        }
        return buildRequest(id);
    }

    // Init GET request using provided ID
    public RequestSpecification initRequest(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Provided ID is null.");
        }
        return buildRequest(id);
    }

    // Shared method to build request
    private RequestSpecification buildRequest(String id) {
        try {
            log.info("Building GET request for object ID: {}", id);

            return new RequestSpecBuilder()
                    .setBaseUri(Path.baseObjectURL)
                    .setBasePath(Path.pathObject)
                    .addQueryParams(prepareParams(id))
                    .addHeaders(prepareHeaders())
                    .build();

        } catch (Exception e) {
            log.error("Failed to build GET object request for ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to build GET object request for ID: " + id, e);
        }
    }
}
