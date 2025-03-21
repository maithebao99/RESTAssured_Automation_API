package Utilities.HandleJson;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

@ScenarioScoped
public class JsonChecker {

    @Inject
    ConvertToJson convertToJson;

    //Kiểm tra nếu một String có rỗng hay không:
    public boolean isStringEmpty(String str) {
        return str != null && str.isEmpty();
    }

    //Kiểm tra nếu một JSONObject có rỗng hay không:
    public boolean isJsonObjectEmpty(JSONObject jsonObject) {
        return jsonObject == null || jsonObject.keySet().isEmpty();
    }


    //Kiểm tra nếu một JSONArray có rỗng hay không:
    public boolean isJsonArrayEmpty(JSONArray jsonArray) {
        return jsonArray == null || jsonArray.length() == 0;
    }

}

