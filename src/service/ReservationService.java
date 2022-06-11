package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {

    static Set<IRoom> roomSet = new HashSet<>();
    static Map<Customer,Reservation> reservations = new HashMap<>();

//    public static void addRoom(IRoom room) {
//        roomSet.add(room);
//    }
//
//    public static IRoom getARoom(String roomId) {
//
//    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = null;
        if (!CustomerService.customers.containsValue(customer)) {
            System.out.println("Account not found. Please create an account");
        }
        else if (!roomSet.contains(room)) {
            System.out.println("Room: #"+room+" is unavailable");
        }
        else {
            newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
            reservations.put(customer, newReservation);

        }
        return newReservation;
    }
//
//    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
//
//    }
//
    public static Collection<Reservation> getCustomersReservation(Customer customer) {
        return (Collection<Reservation>) reservations.get(customer);
    }

    public static void printAllReservation() {
        for (Reservation reservation : reservations.values()) System.out.println(reservation);
    }

}
