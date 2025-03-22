package Model;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@ScenarioScoped
@Getter
@Setter
public class BookingModel {

    private Map<String, Object> body;
}
