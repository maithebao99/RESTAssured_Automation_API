package stepDefinitions.ObjectsAPISteps;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.ObjectModel;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.Assert;
import request.objectsAPI.GetObjectAPI;
import utilities.HandleJson;

@ScenarioScoped
public class GetObjectAPISteps {

    private final int statusCodeSuccess= 200;

    @Inject
    GetObjectAPI getObjectAPI;

    @Inject
    ObjectModel objectModel;

    @Inject
    HandleJson handleJson;

    Response response;

    @Then("Invoke api get object")
    public void sendRequestGetObject()
    {
        response = RestAssured.given().spec(getObjectAPI.initRequest()).when().get();
        System.out.printf(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), statusCodeSuccess);
    }

    @And("Verify response data and body request Get Object API")
    public void verifyResponseGetObject()
    {
        //Handle response to string and string to json object
        String responseString = response.asString();

        //Lấy phần tử đầu tiên trong danh sách khi get object by id
        JSONObject responseObject = handleJson.handleParseFromJsonArrayStringToJsonObject(responseString, 0);

        String idObject = responseObject.getString("id");
        Assert.assertEquals(idObject, objectModel.getId());

        //Check key exits and parse
        if (responseObject.has("name") && !responseObject.isNull("name"))
        {
            String nameObject = responseObject.getString("name");
            Assert.assertEquals(nameObject, objectModel.getName());
        }
        else if(!responseObject.has("name") || responseObject.isNull("name"))
        {
            Assert.fail("Key 'name' not exits");
        }

        //Check key exits and parse
        if (responseObject.has("data") && !responseObject.isNull("data"))
        {
            JSONObject dataObject = responseObject.getJSONObject("data");
            JSONAssert.assertEquals(dataObject, objectModel.getDataObject(), false);
        }
        else if (!responseObject.has("data") || responseObject.isNull("data"))
        {
            Assert.fail("Key 'data' not exits");
        }

    }
}
