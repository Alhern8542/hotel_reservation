package model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, enumeration, 0.00);
    }

    @Override
    final public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
