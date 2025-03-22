package Utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@Getter
@ScenarioScoped
public class Path {

    private final String baseObjectURL = "https://api.restful-api.dev";

    private final String pathObject = "/objects";

    private final String baseBookingURL = "https://restful-booker.herokuapp.com/";

    private final String pathBooking = "booking/";
}
