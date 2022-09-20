package StepProject;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static String flightPath = "/home/ufaz/Downloads/test3.txt";
    public static String bookingPath = "/home/ufaz/Downloads/test4.txt";

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        File flightFile = new File(flightPath);
        File bookingFile = new File(bookingPath);

        FlightService fs =  new FlightService(new CollectionFlightDao(flightFile));
        BookingService bs =  new BookingService(new CollectionBookingDao(bookingFile));

        FlightController fc = new FlightController(fs);
        BookingController bc = new BookingController(bs);

//        fc.fs.generate();
//
        Iterator<Flight> iter = fc.fs.cfd.getAllFlight().iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }

//        /* Search flight by ID */
//        System.out.println("Search flight by flight ID.");
//        System.out.print("Please enter flight ID: ");
//        int flightID=sc.nextInt();
//        System.out.println(fc.fs.cfd.getFlightById(flightID));
//
//        System.out.println();
//        System.out.println();
//
//        // Ticket{flightID=5, origin='Kiev', destination='Baku', flightDate='2023/03/02', flightTime='02:37', seatAvailable=5}
//
//        System.out.println("SEARCH FLIGHT");
//        System.out.print("Please enter destination: ");
//        String destination = sc.next();
//        System.out.print("Please enter date: ");
//        String date = sc.next();
//        System.out.print("Please enter a number of passengers: ");
//        int remainingSeat = sc.nextInt();
//
//        Iterator<Flight> it = fc.fs.searchFlight(destination,date,remainingSeat).iterator();
//
//        while(it.hasNext()) {
//            System.out.println(it.next().toString());
//        }
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////
//
////        Iterator<BookingApp> iter = bc.bs.cbd.getAllBooking().iterator();
////
////        while(iter.hasNext()) {
////            System.out.println(iter.next().toString());
////        }
//

        System.out.println();
        System.out.println();
        System.out.print("Enter a flight id to book: ");
        int bookFLight = sc.nextInt();
        List<Flight> newFlight = fc.fs.cfd.getFlightById(bookFLight);
        Iterator<Flight> itt = newFlight.iterator();
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your surname: ");
        String surname = sc.next();

        while(itt.hasNext()) {
            Flight ff = itt.next();

            int bookID = ff.getFlightID();
            String bookOrigin = ff.getOrigin();
            String bookDestination = ff.getDestination();
            String bookDate = ff.getFlightDate();
            String bookTime = ff.getFlightTime();
            int seats = ff.getSeatAvailable();

            BookingApp ba = new BookingApp();
            ba.setPassengerName(name);
            ba.setPassengerSurname(surname);
            ba.setBookingID(bookID);
            ba.setBookingOrigin(bookOrigin);
            ba.setBookingDestination(bookDestination);
            ba.setBookingDate(bookDate);
            ba.setBookingTime(bookTime);

            bc.bs.cbd.saveBooking(ba);

            Iterator<Flight> iter3 = fc.fs.cfd.getFlightById(bookFLight).iterator();
            while(iter3.hasNext()) {
                Flight fff = iter3.next();
                fff.setSeatAvailable(seats-1);
                fc.fs.cfd.deleteFlight(bookFLight);
                fc.fs.cfd.saveFlight(fff);
            }
        }

        Iterator<BookingApp> iter2 = bc.bs.cbd.getAllBooking().iterator();
        while(iter2.hasNext()) {
            System.out.println(iter2.next().toString());
        }

        Iterator<Flight> iter4 = fc.fs.cfd.getAllFlight().iterator();

        while(iter4.hasNext()) {
            System.out.println(iter4.next().toString());
        }


    }
}