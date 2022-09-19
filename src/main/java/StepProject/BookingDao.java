package StepProject;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<BookingApp> getAllBooking();
    Optional<BookingApp> getBookingById(int id);
    void cancelBooking(int id);
    void saveBooking(BookingApp b);
}
