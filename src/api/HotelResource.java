package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    static IRoom thisRoom;
    static ReservationService thisReservationService = new ReservationService();
    static CustomerService thisCustomerService = new CustomerService();

    public Customer getCustomer(String email) {
        return thisCustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        thisCustomerService.addCustomer(email, firstName, lastName);
    }

     public IRoom getRoom(String roomNumber) {
         return thisReservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, String roomId, String checkIn, String checkOut) {
        Customer customer = getCustomer(customerEmail);
        IRoom room = getRoom(roomId);
        Date checkInDate = new Date(checkIn);
        Date checkOutDate = new Date(checkOut);
        return thisReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Reservation getCustomersReservations(String customerEmail) {
        return thisReservationService.getCustomersReservation(thisCustomerService.getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(String checkIn, String checkOut) {
        Date checkInDate = new Date(checkIn);
        Date checkOutDate = new Date(checkOut);
        return thisReservationService.findRooms(checkInDate, checkOutDate);
    }

}
