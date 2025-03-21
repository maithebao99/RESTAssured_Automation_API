package utilities;

import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ScenarioScoped
public class HandleJson {

    //Read json from Json Object to String
    public String readFileToString(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    //Read json from Json Object to Object
    public JSONObject readFileToJsonObject(File file, Charset charset) throws IOException {
        // Đọc tất cả byte từ file và chuyển đổi thành String
        String content = new String(Files.readAllBytes(file.toPath()), charset);

        // Chuyển String thành JSONObject và trả về
        return new JSONObject(content);
    }

    //Convert from Json String to Json Object
    public JSONObject convertStringToJsonObject(String content) {
        // Phân tích cú pháp JSON
        JSONObject jsonObject = new JSONObject(content);
        return jsonObject;
    }

    public void parseJsonToMap(JSONObject jsonObject, Map<String, Object> resultMap) {
        // Lấy tất cả các key từ JSONObject
        JSONArray keys = jsonObject.names();

        // Duyệt qua tất cả các key
        for (int i = 0; i < keys.length(); i++) {
            try {
                String key = keys.getString(i); // Lấy key tại vị trí i
                Object value = jsonObject.get(key); // Lấy giá trị tương ứng với key

                // Kiểm tra xem value có phải là một JSONObject không
                if (value instanceof JSONObject) {
                    // Nếu là JSONObject, gọi hàm parseJsonToMap đệ quy
                    Map<String, Object> nestedMap = new HashMap<>();
                    parseJsonToMap((JSONObject) value, nestedMap);  // Đệ quy xử lý nested JSONObject
                    resultMap.put(key, nestedMap); // Thêm vào map
                }
                // Kiểm tra xem value có phải là một JSONArray không
                else if (value instanceof JSONArray) {
                    // Nếu là JSONArray, gọi hàm parseJsonArray để xử lý
                    resultMap.put(key, parseJsonArray((JSONArray) value));  // Xử lý mảng JSON
                }
                else {
                    // Nếu không phải JSONObject hoặc JSONArray, lưu vào map
                    resultMap.put(key, value);
                }
            } catch (Exception e) {
                System.out.println("Error retrieving value for key: " + keys.getString(i));
            }
        }
    }

    // Hàm để parse JSON arrays và lưu vào List
    public Object parseJsonArray(JSONArray jsonArray) {
        // Duyệt qua tất cả các phần tử trong JSONArray và lưu vào List
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            Object item = jsonArray.get(i);

            // Nếu item trong mảng là JSONObject, gọi đệ quy để parse
            if (item instanceof JSONObject) {
                Map<String, Object> nestedMap = new HashMap<>();
                parseJsonToMap((JSONObject) item, nestedMap);
                resultArray.put(nestedMap);
            }
            // Nếu item trong mảng là JSONArray, gọi lại hàm parseJsonArray đệ quy
            else if (item instanceof JSONArray) {
                resultArray.put(parseJsonArray((JSONArray) item));
            } else {
                // Nếu là giá trị đơn giản (String, int, boolean, v.v.), lưu vào array
                resultArray.put(item);
            }
        }
        return resultArray;
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

    public JSONObject convertResponseToJsonObject(Response response)
    {
        String stringResponse = response.asString();
        JSONObject jsonReponse = new JSONObject(stringResponse);

        return jsonReponse;
    }

}
