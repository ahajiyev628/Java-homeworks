package StepProject;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static String path = "/home/ufaz/Downloads/test2.txt";

    public static void main(String[] args) throws ParseException, IOException {

        File file = new File(path);

        FlightService fs =  new FlightService(new CollectionFlightDao(file));

        FlightController fc = new FlightController(fs);

        fc.fs.cfd.getAllFlight();

       // fc.fs.cfd.saveFlight(new Flight(12,"Baku","Kiev","24/11/1998","10:24",10));
        fc.fs.cfd.saveFlight(new Flight("Kiev","Baku"));

        fc.fs.generate();

        Iterator<Flight> iter = fc.fs.cfd.getAllFlight().iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
}

