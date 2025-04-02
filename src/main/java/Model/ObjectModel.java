package Model;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@ScenarioScoped
@Getter
@Setter
public class ObjectModel {


    private JSONObject body;

    private String id;
    private String invalidId;
}
