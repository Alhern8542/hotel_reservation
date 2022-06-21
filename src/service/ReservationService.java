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
        if (roomsAvailable.contains(room)) {
            if (!CustomerService.customers.containsValue(customer)) {
                System.out.println("Account not found. Please create an account");
            } else if (!rooms.containsValue(room)) {
                System.out.println("Room: #" + room + " is unavailable");
            } else {
                newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
                reservations.put(customer, newReservation);
            }
        }
        else {
            System.out.println("Room "+room.getRoomNumber()+" is unavailable for reservation");
        }
        return newReservation;
    }

    static List<IRoom> roomsAvailable = new ArrayList<>();
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        roomsAvailable.clear();
        for (IRoom roomAdd : rooms.values()) {
            if (!reservations.isEmpty()) {
                for (Reservation res : reservations.values()) {
                    if (roomAdd.equals(res.getRoom())) {
                        Date in = res.getCheckInDate();
                        Date out = res.getCheckOutDate();
                        if ( (checkInDate.before(in) && checkOutDate.before(in)) || (checkInDate.after(out) && checkOutDate.after(out)) ) {
                            roomsAvailable.add(roomAdd);
                        }
                    } else roomsAvailable.add(roomAdd);
                }
            }
            else roomsAvailable.add(roomAdd);
        }
        return roomsAvailable;
    }

    public static Reservation getCustomersReservation(Customer customer) {
        return reservations.get(customer);
    }

    public static void printAllReservation() {
        for (Reservation reservation : reservations.values()) System.out.println(reservation);
    }

    public static Collection<IRoom> getAllRooms() {
        List<IRoom> roomList = new ArrayList<>();
        for (IRoom room : rooms.values()) {
            roomList.add(room);
        }
        return roomList;
    }

    public static Date getCheckInDate() {
        return getCheckInDate();
    }

    public static Date getCheckOutDate() {
        return getCheckOutDate();
    }

}
