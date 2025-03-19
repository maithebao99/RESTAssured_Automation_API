package utilities;

import io.cucumber.guice.ScenarioScoped;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class HandleJson {

    //Read json from Json Object to String
    public String readFileToString(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()),charset);
    }

    //Read json from Json Object to Object
    public JSONObject readFileToJsonObject(File file, Charset charset) throws IOException {
        // Đọc tất cả byte từ file và chuyển đổi thành String
        String content = new String(Files.readAllBytes(file.toPath()), charset);

        // Chuyển String thành JSONObject và trả về
        return new JSONObject(content);
    }

    //Convert from Json String to Json Object
    public JSONObject convertStringToJsonObject(String content)
    {
            // Phân tích cú pháp JSON
            JSONObject jsonObject = new JSONObject(content);
            return  jsonObject;
    }

    //Convert from Json Array to Json Object
    public JSONObject getObjectInJsonArray(String JsonArrayString, int indexJsonObject) {
        // Phân tích cú pháp chuỗi JSON thành JSONArray
        JSONArray jsonArray = new JSONArray(JsonArrayString);

        // Tạo một đối tượng JSON (JSONObject) để lưu kết quả chuyển đổi
        JSONObject jsonObject = new JSONObject();

        // Duyệt qua từng phần tử trong JSONArray và chuyển thành JSONObject
        for (int i = 0; i < jsonArray.length(); i++) {
            // Lấy phần tử hiện tại của JSONArray
            JSONObject currentJsonObject = jsonArray.getJSONObject(indexJsonObject);
            jsonObject = currentJsonObject;
        }
        return jsonObject;
    }


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
