package UI;

import api.AdminResource;
import model.RoomType;

import java.util.Scanner;

public class AdminMenu {

    public static void admin() {
        boolean keepRunning2 = true;
        try {
            while (keepRunning2) {
                try {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("------------------------------");
                    System.out.println("         (Admin Menu)");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    System.out.println("------------------------------");
                    System.out.println("Enter number selection (1-5)...");
                    int selection = Integer.parseInt(scanner2.nextLine());

                    switch (selection) {
                        case 1:
                            System.out.println(AdminResource.getAllCustomers());
                            break;
                        case 2:
                            System.out.println(AdminResource.getAllRooms());
                            break;
                        case 3:
                            //TODO: test method
                            AdminResource.displayAllReservations();
                            break;
                        case 4:
                            while (true) {
                                System.out.println("Enter room#:");
                                String roomNum = scanner2.nextLine();
                                System.out.println("Enter price");
                                Double price = Double.parseDouble(scanner2.nextLine());
                                RoomType bedType;
                                while (true) {
                                    System.out.println("Enter type:\n1. Single bed\n2. Double bed");
                                    int type = Integer.parseInt(scanner2.nextLine());
                                    if (type == 1) {
                                        bedType = RoomType.SINGLE;
                                        break;
                                    }
                                    else if(type == 2) {
                                        bedType = RoomType.DOUBLE;
                                        break;
                                    }
                                    else {
                                        System.out.println("Please enter 1 or 2");
                                    }
                                }
                                AdminResource.addRoom(roomNum, bedType, price);
                                int extraRoom;
                                while (true) {
                                    System.out.println("Would you like to add another room?\n1. Yes\n2. No");
                                    extraRoom = Integer.parseInt(scanner2.nextLine());
                                    if (extraRoom == 1) {
                                        break;
                                    }
                                    else if(extraRoom == 2) {
                                        break;
                                    }
                                    else {System.out.println("Please enter 1 or 2");}
                                }
                                if(extraRoom == 2) {break;}
                            }
                            break;
                        case 5:
                            while (true) {
                                System.out.println("Back to Main Menu?\n1. Yes\n2. No");
                                int choice = Integer.parseInt(scanner2.nextLine());
                                if (choice == 1) {
                                    keepRunning2 = false;
                                    break;
                                } else if (choice == 2) {
                                    break;
                                } else System.out.println("Please select option 1 or 2");
                            }
                            break;
                        default:
                            System.out.println("\n" +
                                    "Invalid selection, please select (1-5) only");
                    }

                }
                catch (Exception ex) {
                    System.out.println("\nError - Invalid Input\n");
                }

            }

        }   catch (Exception e) {
                throw new RuntimeException(e);
            }

    }



}
