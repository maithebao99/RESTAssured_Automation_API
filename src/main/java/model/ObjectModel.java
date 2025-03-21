package model;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

@ScenarioScoped
@Getter
@Setter
public class ObjectModel {


    private Map<String, Object> body;
    private Map<String, Object> response;

    private String id;
}
