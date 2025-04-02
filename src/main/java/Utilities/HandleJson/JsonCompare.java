package Utilities.HandleJson;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonCompare {

    // Hàm so sánh hai đối tượng JSON
    public static boolean compareJsonObjects(JSONObject json1, JSONObject json2) {
        // Duyệt qua tất cả các key trong json1 và kiểm tra sự tồn tại trong json2
        for (String key : json1.keySet()) {
            // Kiểm tra xem json2 có chứa key này không
            if (json2.has(key)) {
                Object value1 = json1.get(key);
                Object value2 = json2.get(key);

                // Kiểm tra nếu giá trị là JSONObject
                if (value1 instanceof JSONObject && value2 instanceof JSONObject) {
                    // So sánh đối tượng JSON con
                    if (!compareJsonObjects((JSONObject) value1, (JSONObject) value2)) {
                        return false; // Nếu giá trị JSON con không giống nhau
                    }
                }
                // Kiểm tra nếu giá trị là JSONArray
                else if (value1 instanceof JSONArray && value2 instanceof JSONArray) {
                    // So sánh mảng
                    if (!compareJsonArrays((JSONArray) value1, (JSONArray) value2)) {
                        return false; // Nếu mảng không giống nhau
                    }
                }
                // Nếu là các kiểu dữ liệu khác, so sánh trực tiếp giá trị
                else if (!value1.equals(value2)) {
                    return false; // Nếu giá trị không giống nhau
                }
            } else {
                return false; // Nếu json2 không chứa key này
            }
        }
        return true; // Nếu tất cả các giá trị của key giống nhau
    }

    // Hàm so sánh hai mảng JSON
    public static boolean compareJsonArrays(JSONArray array1, JSONArray array2) {
        // Nếu độ dài mảng khác nhau, trả về false
        if (array1.length() != array2.length()) {
            return false;
        }

        // So sánh từng phần tử trong mảng
        for (int i = 0; i < array1.length(); i++) {
            Object value1 = array1.get(i);
            Object value2 = array2.get(i);

            // Nếu phần tử là JSONObject, gọi lại hàm compareJsonObjects
            if (value1 instanceof JSONObject && value2 instanceof JSONObject) {
                if (!compareJsonObjects((JSONObject) value1, (JSONObject) value2)) {
                    return false;
                }
            }
            // Nếu phần tử là JSONArray, gọi lại hàm compareJsonArrays
            else if (value1 instanceof JSONArray && value2 instanceof JSONArray) {
                if (!compareJsonArrays((JSONArray) value1, (JSONArray) value2)) {
                    return false;
                }
            }
            // So sánh các giá trị khác (số, chuỗi, boolean, ...)
            else if (!value1.equals(value2)) {
                return false;
            }
        }
        return true;
    }
}
