package api;

import model.Customer;
import model.IRoom;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;

public class AdminResource {

    static ReservationService thisReservationService = new ReservationService();
    static CustomerService thisCustomerService = new CustomerService();

    public Customer getCustomer(String email) {
        return thisCustomerService.getCustomer(email);
    }

    public void addRoom(String roomNumber, RoomType type, Double price) {
        thisReservationService.addRoom(roomNumber, type, price);
        System.out.println(thisReservationService.getARoom(roomNumber));
    }

    public Collection<IRoom> getAllRooms() {
        return thisReservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return thisCustomerService.getAllCustomers();
    }

    public void displayAllReservations() {
        thisReservationService.printAllReservation();
    }

}
