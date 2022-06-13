package model;

public class Room implements IRoom {

    String roomNumber;
    Double price;
    RoomType enumeration;

    public Room(String roomNumber, RoomType enumeration, Double price) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }
    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() { return false; }

    @Override
    public String toString() {
        return "Room: #"+roomNumber+"\nPrice: $"+price+"\nType: "+enumeration;
    }

}
