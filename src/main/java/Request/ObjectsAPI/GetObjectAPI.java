package Request.ObjectsAPI;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import Model.ObjectModel;
import Utilities.Path;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class GetObjectAPI {

    @Inject
    ObjectModel objectModel;

    @Inject
    Path path;

    private Map<String, String> param;
    private Map<String, String> header;
    private RequestSpecification request;

    private void setParam()
    {
        param = new HashMap<>();
        param.put("id", objectModel.getId());
    }

    private void setParam(String id)
    {
        param = new HashMap<>();
        param.put("id", id);
    }

    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("accept","application/json");
    }

    public RequestSpecification initRequest()
    {
        setParam();
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseObjectURL())
                .setBasePath(path.getPathObject())
                .addQueryParams(param)
                .addHeaders(header)
                .build();
        return request;
    }

    public RequestSpecification initRequest(String id)
    {
        setParam(id);
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseObjectURL())
                .setBasePath(path.getPathObject())
                .addQueryParams(param)
                .addHeaders(header)
                .build();
        return request;
    }
}
