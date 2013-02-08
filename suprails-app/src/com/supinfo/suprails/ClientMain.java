package com.supinfo.suprails;

import com.supinfo.suprails.webservices.Customer;
import com.supinfo.suprails.webservices.CustomerOrder;
import com.supinfo.suprails.webservices.Trip;
import com.supinfo.suprails.webservices.TripService;
import com.supinfo.suprails.webservices.TripWebService;

import java.util.List;
import java.util.Scanner;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
public class ClientMain {

    public static void main(String[] args) {
        TripWebService service = new TripService().getTripWebServicePort();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        do {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAllTrip(service);
                    break;
                case 2:
                    buyTrip(service);
                    break;
                case 3:
                    System.out.println("Bye");
                    quit = true;
                    break;
            }
        } while (!quit);
    }

    private static void displayMenu() {
        System.out.println("Menu: ");
        System.out.println("1 to show all trips");
        System.out.println("2 to buy a trip");
        System.out.println("3 quit");
    }

    private static void showAllTrip(TripWebService service) {
        List<Trip> trips = service.getAllTrips();
        for (Trip trip : trips) {
            System.out.println("Id: ");
            System.out.println("\t" + trip.getId());
            System.out.println("Departure Station: ");
            System.out.println("\t" + trip.getDepartureStation().getName());
            System.out.println("Arrival Station: ");
            System.out.println("\t" + trip.getArrivalStation().getName());
            System.out.println("Price :");
            System.out.println("\t" + trip.getPrice());
        }
    }

    private static void buyTrip(TripWebService service) {
        Scanner scanner = new Scanner(System.in);

        Customer customer = getCustomerInfo(scanner);
        Trip trip = getTrip(service, scanner);

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setTrip(trip);

        service.processOrder(customerOrder);
    }

    private static Customer getCustomerInfo(Scanner scanner) {
        Customer customer = new Customer();
        System.out.println("FirstName: ");
        customer.setFirstName(scanner.nextLine());
        System.out.println("LastName: ");
        customer.setLastName(scanner.nextLine());
        System.out.println("Email: ");
        customer.setEmail(scanner.nextLine());
        return customer;
    }

    private static Trip getTrip(TripWebService service, Scanner scanner) {
        System.out.println("Trip id: ");
        Long idTrip = scanner.nextLong();
        List<Trip> trips = service.getAllTrips();
        Trip trip = null;
        for (Trip currentTrip : trips) {
            if (currentTrip.getId().equals(idTrip)) {
                trip = currentTrip;
                break;
            }
        }
        return trip;
    }

}
