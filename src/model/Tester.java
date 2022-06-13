package model;

import service.CustomerService;

public class Tester {

    public static void main(String[] args) {

        IRoom test1 = new Room("1408", RoomType.SINGLE, 19.99);
        IRoom test2 = new FreeRoom("404", RoomType.SINGLE);
        IRoom test3 = new Room("901", RoomType.DOUBLE, 29.99);

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }

}
