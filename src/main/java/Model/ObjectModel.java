package Model;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@ScenarioScoped
@Getter
@Setter
public class ObjectModel {


    private Map<String, Object> body;
    private Map<String, Object> response;

    private String id;
    private String invalidId;
}
