package request.objectsAPI;
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

import model.ObjectModel;
import org.json.JSONObject;
import utilities.*;

@Getter
@Setter
@ScenarioScoped
public class AddObjectAPI {

    @Inject
    HandleJson handleJson;

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
        File file = new File("TestSuites/data/objectsAPI/AddObjectData/bodyAddObject.json");
        //Handle to Json String
        JSONObject jsonObject = handleJson.readFileToJsonObject(file, Charset.defaultCharset());

        //Handle Json String to Json Object
        JSONObject expectJsonObject = jsonObject.getJSONObject(caseBody);

        if(expectJsonObject.has("name"))
        {
            //Hanle save body to "ObjectModel" Class
            String name = expectJsonObject.getString("name");
            objectModel.setName(name);
        }

        if(expectJsonObject.has("data"))
        {
            JSONObject dataObject = expectJsonObject.getJSONObject("data");
            objectModel.setDataObject(dataObject);
        }

        //Handle Json Object to Json String and save to body
        body = expectJsonObject.toString();
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
                .setBaseUri(path.getBaseURL())
                .setBasePath(path.getPathAddObject())
                .setBody(body)
                .addHeaders(header)
                .build();
        return request;
    }
}
