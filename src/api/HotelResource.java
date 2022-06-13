package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

//    TODO: provide a static reference

    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    static public IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

// TODO: fix checkindate and checkoutdate
    public static Reservation bookARoom(String customerEmail, String roomId, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.getCustomer(customerEmail);
        IRoom room = getRoom(roomId);
        return ReservationService.reserveARoom(customer,room,checkInDate,checkOutDate);
    }

//    public Collection<Reservation> getCustomersReservations(String customerEmail) {
//
//    }

//    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
//
//    }

}
