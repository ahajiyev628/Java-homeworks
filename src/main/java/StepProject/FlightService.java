package StepProject;

import java.io.File;
import java.time.LocalDateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class FlightService {
    private File f;
    LocalDateTime ldt;

    public File getF() {
        return f;
    }
    public CollectionFlightDao cfd = new CollectionFlightDao(getF());

    public void setF(File f) {
        this.f = f;
    }

    public FlightService() {
    }

    public FlightService(CollectionFlightDao cfd) {
        this.cfd = cfd;
    }

    Calendar c = Calendar.getInstance(Locale.ENGLISH);

    public String randomDateGenerator() {
        Date d = c.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        return sdf1.format(d) + (int) (Math.random() * 10);
    }

    public String randomDateTimeGenerator() {
        Date d = c.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
        return sdf2.format(d) + (int) (Math.random() * 100);
    }

    public void generate() throws ParseException {
        for (int i = 0; i <10; i++) {
            cfd.saveFlight(new Flight((int)(Math.random()*10),"Kiev","Baku", randomDateGenerator(), randomDateTimeGenerator(), (int)(Math.random()*10)));
        }
    }
}
