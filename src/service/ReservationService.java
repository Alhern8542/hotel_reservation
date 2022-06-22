package service;

import model.*;

import java.util.*;

public class ReservationService {

    static Map<String,IRoom> rooms = new HashMap<>();
    static Map<Customer,Reservation> reservations = new HashMap<>();
    static List<IRoom> roomsAvailable = new ArrayList<>();

    public void addRoom(String roomNumber, RoomType type, Double price) {
        IRoom room = new Room(roomNumber, type, price);
        rooms.put(roomNumber, room);
    }

    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
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

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        roomsAvailable.clear();
        for (IRoom roomAdd : rooms.values()) {
            roomsAvailable.add(roomAdd);
        }
        for (IRoom roomDel : rooms.values()) {
            if (!reservations.isEmpty()) {
                for (Reservation res : reservations.values()) {
                    if (roomDel.equals(res.getRoom())) {
                        Date in = res.getCheckInDate();
                        Date out = res.getCheckOutDate();
                        if (!((checkInDate.before(in) && checkOutDate.before(in)) || (checkInDate.after(out) && checkOutDate.after(out)))) {
                            roomsAvailable.remove(roomDel);
                        }
                    }
                }
            }
        }
        return roomsAvailable;
    }

    public Collection<IRoom> getRecommendations(Date newCheckInDate, Date newCheckOutDate, String checkIn, String checkOut) {
        System.out.println("Sorry no rooms are available from: "+checkIn+" and "+checkOut);
        System.out.println("Here are some recommendations for the same days next week...");
        for (IRoom roomAdd : rooms.values()) {
            roomsAvailable.add(roomAdd);
        }
        for (IRoom roomDel : rooms.values()) {
            if (!reservations.isEmpty()) {
                for (Reservation res : reservations.values()) {
                    if (roomDel.equals(res.getRoom())) {
                        Date in = res.getCheckInDate();
                        Date out = res.getCheckOutDate();
                        if (!((newCheckInDate.before(in) && newCheckOutDate.before(in)) || (newCheckInDate.after(out) && newCheckOutDate.after(out)))) {
                            roomsAvailable.remove(roomDel);
                        }
                    }
                }
            }
        }
        return roomsAvailable;
    }

    public Reservation getCustomersReservation(Customer customer) {
        return reservations.get(customer);
    }

    public void printAllReservation() {
        for (Reservation reservation : reservations.values()) System.out.println(reservation);
    }

    public Collection<IRoom> getAllRooms() {
        List<IRoom> roomList = new ArrayList<>();
        for (IRoom room : rooms.values()) {
            roomList.add(room);
        }
        return roomList;
    }

    Date getCheckInDate() {
        return getCheckInDate();
    }

    Date getCheckOutDate() {
        return getCheckOutDate();
    }

}
