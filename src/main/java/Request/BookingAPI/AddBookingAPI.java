package Request.BookingAPI;

import Model.BookingModel;
import Utilities.FileUtils;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ScenarioScoped
public class AddBookingAPI {

    @Inject
    private BookingModel bookingModel;

    @Inject
    private Path path;

    private Map<String, String> createHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "*/*");
        return header;
    }

    private String extractBody(String bodycase) throws IOException {
        File file = new File("TestSuites/Data/BookingData/bodyAddBooking.json");

        log.info("Reading JSON file for booking body from: {}", file.getPath());
        JSONObject fullJson = FileUtils.readFileToJsonObject(file, Charset.defaultCharset());

        if (!fullJson.has(bodycase)) {
            throw new IllegalArgumentException("Body case key '" + bodycase + "' not found in JSON file.");
        }

        JSONObject bodyObject = fullJson.getJSONObject(bodycase);
        bookingModel.setBody(bodyObject);
        log.info("Extracted body for case '{}': {}", bodycase, bodyObject.toString());

        return bodyObject.toString();
    }

    public RequestSpecification initRequestAddBooking(String bodycase) {
        try {
            Map<String, String> headers = createHeader();
            String body = extractBody(bodycase);

            log.info("Initializing AddBookingAPI request with case: {}", bodycase);

            return new RequestSpecBuilder()
                    .setBaseUri(Path.baseBookingURL)
                    .setBasePath(Path.pathBooking)
                    .addHeaders(headers)
                    .setBody(body)
                    .build();

        } catch (IOException e) {
            log.error("Failed to read or parse booking body file: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to prepare request body from file.");
        } catch (Exception e) {
            log.error("Failed to initialize AddBookingAPI request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to build AddBookingAPI request.");
        }
    }
}
