package api;

import model.Customer;
import model.IRoom;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void addRoom(String roomNumber, RoomType type, Double price) {
        ReservationService.addRoom(roomNumber, type, price);
        System.out.println(ReservationService.getARoom(roomNumber));
    }

    public static Collection<IRoom> getAllRooms() {
        return ReservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers() {
        return CustomerService.getAllCustomers();
    }

    public static void displayAllReservations() {
        ReservationService.printAllReservation();
    }

}
