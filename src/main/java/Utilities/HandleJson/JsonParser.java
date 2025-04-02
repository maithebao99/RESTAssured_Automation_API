package Utilities.HandleJson;

import io.cucumber.guice.ScenarioScoped;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class JsonParser {

    //Parse key - value trong json and save to map
    public static void parseJsonObjectToMap(JSONObject jsonObject, Map<String, Object> resultMap) {
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
                    parseJsonObjectToMap((JSONObject) value, nestedMap);  // Đệ quy xử lý nested JSONObject
                    resultMap.put(key, nestedMap); // Thêm vào map
                }
                // Kiểm tra xem value có phải là một JSONArray không
                else if (value instanceof JSONArray) {
                    // Nếu là JSONArray, gọi hàm parseJsonArray để xử lý
                    resultMap.put(key, parseValueIsJsonArray((JSONArray) value));  // Xử lý mảng JSON
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
    private static Object parseValueIsJsonArray(JSONArray jsonArray) {
        // Duyệt qua tất cả các phần tử trong JSONArray và lưu vào List
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            Object item = jsonArray.get(i);

            // Nếu item trong mảng là JSONObject, gọi đệ quy để parse
            if (item instanceof JSONObject) {
                Map<String, Object> nestedMap = new HashMap<>();
                parseJsonObjectToMap((JSONObject) item, nestedMap);
                resultArray.put(nestedMap);
            }
            // Nếu item trong mảng là JSONArray, gọi lại hàm parseJsonArray đệ quy
            else if (item instanceof JSONArray) {
                resultArray.put(parseValueIsJsonArray((JSONArray) item));
            } else {
                // Nếu là giá trị đơn giản (String, int, boolean, v.v.), lưu vào array
                resultArray.put(item);
            }
        }
        return resultArray;
    }



    // Hàm để parse một JSONArray và lưu vào Map
    public void parseJsonArrayToMap(JSONArray jsonArray, Map<String, Object> resultMap) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Object item = jsonArray.get(i);

            // Kiểm tra nếu item trong mảng là JSONObject
            if (item instanceof JSONObject) {
                parseValueIsJsonObject((JSONObject) item, resultMap, "item" + i);  // Đặt tên key khác nhau cho từng phần tử
            }
            // Nếu item trong mảng là JSONArray
            else if (item instanceof JSONArray) {
                parseJsonArrayToMap((JSONArray) item, resultMap);
            } else {
                // Nếu là giá trị đơn giản, thêm vào Map
                resultMap.put("item" + i, item);
            }
        }
    }

    // Hàm để parse một JSONObject và lưu vào Map
    private void parseValueIsJsonObject(JSONObject jsonObject, Map<String, Object> resultMap, String parentKey) {
        JSONArray keys = jsonObject.names();

        // Duyệt qua tất cả các key trong JSONObject
        for (int i = 0; i < keys.length(); i++) {
            String key = keys.getString(i);
            Object value = jsonObject.get(key);

            String fullKey = parentKey + "." + key; // Tạo khóa đầy đủ (parent key + child key)

            // Kiểm tra nếu giá trị là JSONObject
            if (value instanceof JSONObject) {
                Map<String, Object> nestedMap = new HashMap<>();
                parseValueIsJsonObject((JSONObject) value, nestedMap, fullKey);
                resultMap.put(fullKey, nestedMap);
            }
            // Kiểm tra nếu giá trị là JSONArray
            else if (value instanceof JSONArray) {
                Map<String, Object> nestedArrayMap = new HashMap<>();
                parseJsonArrayToMap((JSONArray) value, nestedArrayMap); // Đệ quy xử lý JSONArray
                resultMap.put(fullKey, nestedArrayMap);
            } else {
                // Nếu là kiểu dữ liệu đơn giản (String, int, boolean...)
                resultMap.put(fullKey, value);
            }
        }
    }
}
