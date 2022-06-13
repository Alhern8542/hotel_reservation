package service;

import model.*;

import java.util.*;

public class ReservationService {

    static Map<String,IRoom> rooms = new HashMap<>();
    static Map<Customer,Reservation> reservations = new HashMap<>();

    public static void addRoom(String roomNumber, RoomType type, Double price) {
        IRoom room = new Room(roomNumber, type, price);
        rooms.put(roomNumber, room);
    }

    public static IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation newReservation = null;
        if (!CustomerService.customers.containsValue(customer)) {
            System.out.println("Account not found. Please create an account");
        }
        else if (!rooms.containsValue(room)) {
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
