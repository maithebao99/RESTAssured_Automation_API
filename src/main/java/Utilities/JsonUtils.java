package Utilities;

import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@ScenarioScoped
public class JsonUtils {

    //Convert response to json object
    public static JSONObject convertResponseToJsonObject(Response response)
    {
        String stringResponse = response.asString();
        JSONObject jsonReponse = new JSONObject(stringResponse);

        return jsonReponse;
    }

    //Convert reponse to json array
    public static JSONArray convertResponseToJsonArray(Response response)
    {
        String stringResponse = response.asString();
        JSONArray jsonArrayReponse = new JSONArray(stringResponse);

        return jsonArrayReponse;
    }
}
