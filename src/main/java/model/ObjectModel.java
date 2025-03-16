package model;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@ScenarioScoped
@Getter
@Setter
public class ObjectModel {


    private String name;
    private JSONObject dataObject;

    private String id;
}
