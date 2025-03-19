package utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@Getter
@ScenarioScoped
public class Path {

    private final String baseURL = "https://api.restful-api.dev";

    private final String pathAddObject = "/objects";

    private final String pathGetObject = "/objects";

    private final String pathUpdateObject = "/objects/";
}
