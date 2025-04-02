package Utilities;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;

@ScenarioScoped
public class Path {

    public static final String baseObjectURL = "https://api.restful-api.dev";

    public static final String pathObject = "/objects";

    public static final String baseBookingURL = "https://restful-booker.herokuapp.com";

    public static final String pathBooking = "/booking/";
}
