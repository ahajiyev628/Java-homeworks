package StepProject;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static String path = "/home/ufaz/Downloads/test3.txt";

    public static void main(String[] args) throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);

        File file = new File(path);

        FlightService fs =  new FlightService(new CollectionFlightDao(file));

        FlightController fc = new FlightController(fs);

        fc.fs.cfd.getAllFlight();

        // fc.fs.cfd.saveFlight(new Flight(12,"Baku","Kiev","24/11/1998","10:24",10));
        //fc.fs.cfd.saveFlight(new Flight("Kiev","Baku"));

        fc.fs.generate();

        Iterator<Flight> iter = fc.fs.cfd.getAllFlight().iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }

        /* Search flight by ID */
        System.out.println("Search flight by flight ID.");
        System.out.print("Please enter flight ID: ");
        int flightID=sc.nextInt();
        System.out.println(fc.fs.cfd.getFlightById(flightID));

        System.out.println();
        System.out.println();

        // Ticket{flightID=5, origin='Kiev', destination='Baku', flightDate='2023/03/02', flightTime='02:37', seatAvailable=5}

        System.out.println("SEARCH FLIGHT");
        System.out.print("Please enter destination: ");
        String destination = sc.next();
        System.out.print("Please enter date: ");
        String date = sc.next();
        System.out.print("Please enter a number of passengers: ");
        int remainingSeat = sc.nextInt();

        Iterator<Flight> it = fc.fs.searchFlight(destination,date,remainingSeat).iterator();

        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }

        // System.out.println(fc.fs.searchFlight("Baku","2023/03/02",5));

    }
}

