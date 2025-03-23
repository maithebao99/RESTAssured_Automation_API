package Utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@ScenarioScoped
@Getter
public class StatusCodeRequest {

    private final int statusCodeSuccess = 200;

    private final int statusCodeNotFound = 404;

}
