package Request.BookingAPI;

import Model.BookingModel;
import Utilities.Path;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class GetDetailBookingAPI {

    private Map<String, String> header;

    private RequestSpecification request;

    @Inject
    Path path;

    @Inject
    StatusCodeRequest statusCodeRequest;

    @Inject
    BookingModel bookingModel;

    private void setHeader()
    {
        header = new HashMap<>();
        header.put("Content-Type", "application/json");
        header.put("Accept", "*/*");
    }

    public RequestSpecification initRequestGetDetailBooking()
    {
        setHeader();
        request = new RequestSpecBuilder()
                .setBaseUri(path.getBaseBookingURL())
                .setBasePath(path.getPathBooking()+bookingModel.getBookingID())
                .addHeaders(header)
                .build();
        return request;
    }
}
