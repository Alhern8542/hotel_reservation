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
// TODO: add recommendations feature
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
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
        if (roomsAvailable.isEmpty()) {
            System.out.println("Sorry rooms are unavailable from: "+checkInDate+" and "+checkOutDate);
            System.out.println("Here are some recommendations...");
            for (IRoom roomAdd : rooms.values()) {
                if (!reservations.isEmpty()) {
                    for (Reservation res : reservations.values()) {
                        if (roomAdd.equals(res.getRoom())) {
                            Date in = res.getCheckInDate();
                            Date out = res.getCheckOutDate();

                            Calendar cal1 = Calendar.getInstance();
                            cal1.setTime(checkInDate);
                            cal1.add(Calendar.DATE, 7);
                            Date newCheckInDate = cal1.getTime();

                            Calendar cal2 = Calendar.getInstance();
                            cal2.setTime(checkOutDate);
                            cal2.add(Calendar.DATE, 7);
                            Date newCheckOutDate = cal1.getTime();

                            if ( (newCheckInDate.before(in) && newCheckOutDate.before(in)) || (newCheckInDate.after(out) && newCheckOutDate.after(out)) ) {
                                roomsAvailable.add(roomAdd);
                            }
                        } else roomsAvailable.add(roomAdd);
                    }
                }
                else roomsAvailable.add(roomAdd);
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
    // TODO: default?
    Date getCheckInDate() {
        return getCheckInDate();
    }

    Date getCheckOutDate() {
        return getCheckOutDate();
    }

}
