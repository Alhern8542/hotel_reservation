package UI;

import api.AdminResource;
import api.HotelResource;

import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;
        try {
            while (keepRunning) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nWelcome to the Hotel Reservation System");
                    System.out.println("------------------------------");
                    System.out.println("         (Main Menu)");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("------------------------------");
                    System.out.println("Enter number selection (1-5)...");
                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {
                        case 1:
                            System.out.println("Enter CheckIn Date: (mm/dd/yyyy)");
                            String checkIn = scanner.nextLine();
                            System.out.println("Enter CheckOut Date: (mm/dd/yyyy)");
                            String checkOut = scanner.nextLine();
                            //findRooms() method here
                            System.out.println("Would you like to book a room?\n1. Yes\n2.No");
                            int book = Integer.parseInt(scanner.nextLine());
                            System.out.println("Do you have an account with us?\n1. Yes\n2.No");
                            int account = Integer.parseInt(scanner.nextLine());
                            System.out.println("Enter your email: (name@domain.com)");
                            String emailToBook = scanner.nextLine();
                            System.out.println("Enter room# you would like to reserve");
                            String room = scanner.nextLine();
                            HotelResource.bookARoom(emailToBook, room, checkIn, checkOut);
                            break;
                        case 2:
                            //See my reservations method
                            break;
                        case 3:
                            try {
                                System.out.println("Enter first name:");
                                String firstName = scanner.nextLine();
                                System.out.println("Enter last name:");
                                String lastname = scanner.nextLine();
                                System.out.println("Enter email: (name@domain.com)");
                                String email = scanner.nextLine();
                                HotelResource.createACustomer(email, firstName, lastname);
                                System.out.println(AdminResource.getCustomer(email));
                            }
                            catch (IllegalArgumentException ex) {
                                System.out.println(ex.getLocalizedMessage());
                            }
                            break;
                        case 4:
                            AdminMenu.admin();
                            break;
                        case 5:
                            System.out.println("Enjoy your stay!\nGoodbye!");
                            keepRunning = false;
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
