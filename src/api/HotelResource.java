package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {



    public static Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        CustomerService.addCustomer(email, firstName, lastName);
    }

    static public IRoom getRoom(String roomNumber) {
        return ReservationService.getARoom(roomNumber);
    }

// TODO: test check in date and check out date
    public static Reservation bookARoom(String customerEmail, String roomId, String checkIn, String checkOut) {
        Customer customer = CustomerService.getCustomer(customerEmail);
        IRoom room = getRoom(roomId);
        Date checkInDate = new Date(checkIn);
        Date checkOutDate = new Date(checkOut);
        return ReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public static Reservation getCustomersReservations(String customerEmail) {
        return ReservationService.getCustomersReservation(AdminResource.getCustomer(customerEmail));
    }

// TODO: test check in date and check out date
    public static Collection<IRoom> findARoom(String checkIn, String checkOut) {
        Date checkInDate = new Date(checkIn);
        Date checkOutDate = new Date(checkOut);
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }

}
