package Request.ObjectsAPI;

import Model.ObjectModel;
import Utilities.Path;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class DeleteObjectAPI {

    private Map<String, String> header;
    private RequestSpecification request;

    @Inject
    Path path;

    @Inject
    ObjectModel objectModel;

    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Accept", "*/*");
        header.put("Content-Type","application/json");
    }

    public RequestSpecification initRequestDeleteObject()
    {
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseURL())
                .setBasePath(path.getPathDeleteObject()+objectModel.getId())
                .addHeaders(header)
                .build();

        return request;

    }

    public RequestSpecification initRequestDeleteObject(String id)
    {
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseURL())
                .setBasePath(path.getPathDeleteObject()+id)
                .addHeaders(header)
                .build();

        return request;

    }
}
