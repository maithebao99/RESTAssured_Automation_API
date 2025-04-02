package Request.ObjectsAPI;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import Model.ObjectModel;
import org.json.JSONObject;
import Utilities.*;
import Utilities.HandleFile.ReadFile;
import Utilities.HandleJson.JsonParser;

@Getter
@Setter
@ScenarioScoped
public class AddObjectAPI {

    @Inject
    JsonParser jsonParser;

    @Inject
    Path path;

    @Inject
    ObjectModel objectModel;

    private String body;
    private Map<String, String> header;
    public RequestSpecification request;


    //Handle set body Add Object API
    private void setBody(String caseBody) throws IOException
    {
        //Get json file from path file
        File file = new File("TestSuites/data/ObjectsData/bodyAddObject.json");
        //Handle to Json String
        JSONObject jsonObject = ReadFile.readFileToJsonObject(file, Charset.defaultCharset());

        //Handle Json String to Json Object
        JSONObject bodyJsonObject = jsonObject.getJSONObject(caseBody);

        objectModel.setBody(bodyJsonObject);

        //Handle Json Object to Json String and save to body
        body = bodyJsonObject.toString();
    }

    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("accept","application/json");
    }

    public RequestSpecification initRequest(String caseBody) throws IOException {
        setBody(caseBody);
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(Path.baseObjectURL)
                .setBasePath(Path.pathObject)
                .setBody(body)
                .addHeaders(header)
                .build();
        return request;
    }
}
