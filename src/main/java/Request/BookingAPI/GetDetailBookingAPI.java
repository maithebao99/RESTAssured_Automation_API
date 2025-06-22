package Request.BookingAPI;

import Model.BookingModel;
import Utilities.Path;
import Utilities.StatusCodeRequest;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ScenarioScoped
public class GetDetailBookingAPI {

    @Inject
    private Path path;

    @Inject
    private StatusCodeRequest statusCodeRequest;

    @Inject
    private BookingModel bookingModel;

    public RequestSpecification initRequestGetDetailBooking() {
        try {
            int bookingId = bookingModel.getBookingID();
            if (bookingId <= 0) {
                throw new IllegalArgumentException("Booking ID must be greater than 0.");
            }

            Map<String, String> header = new HashMap<>();
            header.put("Content-Type", "application/json");
            header.put("Accept", "*/*");

            log.info("Initializing GET detail booking request for booking ID: {}", bookingId);

            return new RequestSpecBuilder()
                    .setBaseUri(Path.baseBookingURL)
                    .setBasePath(Path.pathBooking + bookingId)
                    .addHeaders(header)
                    .build();

        } catch (Exception e) {
            log.error("Failed to initialize GET detail booking request: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to build request for GetDetailBookingAPI.");
        }
    }
}
