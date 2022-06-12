package UI;

import java.util.Scanner;

public class AdminMenu {

    public static void admin() {
        boolean keepRunning2 = true;
        try {
            while (keepRunning2) {
                try {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("-Admin Menu-\n1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    System.out.println("Enter selection (1-5)...");
                    int selection = Integer.parseInt(scanner2.nextLine());

                    switch (selection) {
                        case 1:
                            System.out.println("admin 1 works");
                            //keepRunning2 = false;
                            break;
                        case 2:
                            System.out.println("admin 2 works");
                            //keepRunning2 = false;
                            break;
                        case 3:
                            System.out.println("admin 3 works");
                            //keepRunning2 = false;
                            break;
                        case 4:
                            System.out.println("admin 4 works");
                            //keepRunning2 = false;
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
                                } else System.out.println("Please select 1 or 2");
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

                //scanner2.close();
            }

        }   catch (Exception e) {
                throw new RuntimeException(e);
            }

    }



}
