package Request.ObjectsAPI;

import Utilities.HandleJson.ConvertToJson;
import Utilities.HandleJson.JsonParser;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import Model.ObjectModel;
import org.json.JSONObject;
import Utilities.Path;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class UpdateObjectAPI {
    private Map<String, String> header;
    private String body;
    private RequestSpecification request;

    @Inject
    Path path;

    @Inject
    ObjectModel objectModel;

    @Inject
    AddObjectAPI addObjectAPI;

    @Inject
    JsonParser jsonParser;


    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept", "*/*");
    }

    private void setBody(JSONObject bodyJsonObject) throws IOException {
        changeValues(bodyJsonObject);
        body = bodyJsonObject.toString();

        Map<String, Object> mapBody = new HashMap<>();
        jsonParser.parseJsonObjectToMap(bodyJsonObject, mapBody);
        objectModel.setBody(mapBody);
    }

    public void changeValues(JSONObject jsonObject) {
        // Duyệt qua tất cả các key trong JSONObject
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            // Nếu key là 'createdAt', không thay đổi giá trị
            if (key.equals("createdAt")) {
                continue;
            }

            // Nếu giá trị là một JSONObject (nested object), gọi đệ quy
            if (value instanceof JSONObject) {
                changeValues((JSONObject) value);  // Đệ quy thay đổi giá trị của đối tượng con
            } else {
                // Nếu là giá trị cơ bản, thay đổi giá trị của key
                jsonObject.put(key, "Updated Value");
            }
        }
    }

    public RequestSpecification initRequest(JSONObject bodyJsonObject, String id) throws IOException {
        setBody(bodyJsonObject);
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseObjectURL())
                .setBasePath(path.getPathObject()+"/"+id)
                .addHeaders(header)
                .setBody(body)
                .build();
        return request;
    }
}
