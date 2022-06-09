package model;

public class Tester {

    public static void main(String[] args) {

        /*
        TODO: test email validation; make sure toString() is setup
        Customer testing = new Customer("Alberto", "Hernandez", "alhern8542@gmail.com");
        System.out.println(testing);
        */

        // Testing FreeRoom and Room classes
        FreeRoom testRoom = new FreeRoom("1408",25.0 , RoomType.DOUBLE);
        Room testRoom2 = new Room("504", 499.99, RoomType.SINGLE);
        System.out.println(testRoom);
        System.out.println(testRoom2);

    }

}
