package UI;

import api.AdminResource;
import api.HotelResource;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                            while(true) {
                                String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
                                Pattern pattern = Pattern.compile(regex);
                                String checkIn;
                                String checkOut;
                                while(true) {
                                    System.out.println("Enter CheckIn Date: (mm/dd/yyyy)");
                                    checkIn = scanner.nextLine();
                                    if(pattern.matcher(checkIn).matches()) {
                                        break;
                                    }
                                    else System.out.println("Invalid Date format");
                                }
                                while(true) {
                                    System.out.println("Enter CheckOut Date: (mm/dd/yyyy)");
                                    checkOut = scanner.nextLine();
                                    if(pattern.matcher(checkOut).matches()) {
                                        break;
                                    }
                                    else System.out.println("Invalid Date format");
                                }
                                //findRooms() method here

                                int book;
                                while(true) {
                                    System.out.println("Would you like to book a room?\n1. Yes\n2. No");
                                    book = Integer.parseInt(scanner.nextLine());
                                    if(book == 1 || book == 2) {break;}
                                    else System.out.println("Please enter 1 or 2");
                                }
                                if(book == 2) {break;}
                                int account;
                                while(true) {
                                    System.out.println("Do you have an account with us?\n1. Yes\n2. No");
                                    account = Integer.parseInt(scanner.nextLine());
                                    if(account == 1 || account == 2) {break;}
                                    else System.out.println("Please enter 1 or 2");
                                }
                                if(account == 2) {
                                    System.out.println("Please create an account");
                                    break;
                                }
                                System.out.println("Enter your email: (name@domain.com)");
                                String emailToBook = scanner.nextLine();
                                if(HotelResource.getCustomer(emailToBook) == null) {
                                    System.out.println("Email was not found");
                                    break;
                                }
                                System.out.println("Enter room# you would like to reserve");
                                String room = scanner.nextLine();
                                if(HotelResource.getRoom(room) == null) {
                                    System.out.println("Room was not found");
                                    break;
                                }
                                System.out.println(HotelResource.bookARoom(emailToBook, room, checkIn, checkOut));
                                break;
                            }
                            break;
                        case 2:
                            System.out.println("Enter your reservation email");
                            String reservationEmail = scanner.nextLine();
                            System.out.println(HotelResource.getCustomersReservations(reservationEmail));
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
