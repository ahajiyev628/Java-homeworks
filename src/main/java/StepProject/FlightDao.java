package StepProject;

import java.util.List;
import java.util.Optional;

public interface FlightDao {
    List<Flight> getAllFlight();
    Optional<Flight> getFlightById(int id);
    void deleteFlight(int id);
    void saveFlight(Flight f);
}
