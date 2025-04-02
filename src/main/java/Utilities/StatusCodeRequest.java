package Utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@ScenarioScoped
public class StatusCodeRequest {

    public static final int statusCodeSuccess = 200;

    public static final int statusCodeNotFound = 404;

}
