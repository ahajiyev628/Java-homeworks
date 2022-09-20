package StepProject;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private File bookingFile;

    public File getBookingFile() {
        return bookingFile;
    }
    public void setBookingFile(File bookingFile) {
        this.bookingFile = bookingFile;
    }
    public CollectionBookingDao cbd = new CollectionBookingDao(getBookingFile());

    public BookingService(CollectionBookingDao cbd) {
        this.cbd = cbd;
    }

}
