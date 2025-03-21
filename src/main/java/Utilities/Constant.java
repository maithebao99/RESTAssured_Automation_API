package Utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@ScenarioScoped
@Getter
public class Constant {

    private final int statusCodeSuccess = 200;
}
