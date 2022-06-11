package UI;

import api.HotelResource;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;
        try {
            while (keepRunning) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("-Main Menu-\n1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("Enter selection (1-5)...");
                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {
                        case 1:
                            //
                            //keepRunning = false;
                            break;
                        case 2:
                            //
                            //keepRunning = false;
                            break;
                        case 3:
                            //
                            //keepRunning = false;
                            break;
                        case 4:
                            AdminMenu.admin();
                            //keepRunning = false;
                            break;
                        case 5:
                            System.out.println("Enjoy your stay!\nGoodbye!");
                            keepRunning = false;
                            break;
                        default:
                            System.out.println("\nPlease select (1-5) only");
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
