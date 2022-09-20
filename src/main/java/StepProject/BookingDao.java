package StepProject;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<BookingApp> getAllBooking();
    List<BookingApp> getBookingById(int id);
    void cancelBooking(int id);
    void saveBooking(BookingApp b);
}
