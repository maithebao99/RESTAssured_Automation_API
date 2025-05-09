package Request.BookingAPI;

import Model.BookingModel;
import Utilities.HandleFile.ReadFile;
import Utilities.HandleJson.JsonParser;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class AddBookingAPI {

    private String body;
    private Map<String, String> header;
    private RequestSpecification request;

    @Inject
    BookingModel bookingModel;

    @Inject
    Path path;

    @Inject
    JsonParser jsonParser;

    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "*/*");
    }

    private void setBody(String bodycase) throws IOException {
        File content = new File("TestSuites/Data/BookingData/bodyAddBooking.json");
        JSONObject bodyContent = ReadFile.readFileToJsonObject(content, Charset.defaultCharset());
        JSONObject bodyObject = bodyContent.getJSONObject(bodycase);
        if (!bodyObject.isEmpty())
        {
            bookingModel.setBody(bodyObject);
            body = bodyObject.toString();
        }
    }

    public RequestSpecification initRequestAddBooking(String bodycase) throws IOException {
        setHeader();
        setBody(bodycase);
        request = new RequestSpecBuilder()
                .setBaseUri(Path.baseBookingURL)
                .setBasePath(Path.pathBooking)
                .addHeaders(header)
                .setBody(body)
                .build();

        return request;
    }
}
