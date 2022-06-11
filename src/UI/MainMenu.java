package UI;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        boolean keepRunning = true;
        try(Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                try {
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("Enter selection (1-5)...");
                    int selection = Integer.parseInt(scanner.nextLine());

                    switch (selection) {
                        case 1:
                            System.out.println("case 1 works");
                            keepRunning = false;
                            break;
                        case 2:
                            System.out.println("case 2 works");
                            keepRunning = false;
                            break;
                        case 3:
                            System.out.println("case 3 works");
                            keepRunning = false;
                            break;
                        case 4:
                            System.out.println("case 4 works");
                            keepRunning = false;
                            break;
                        case 5:
                            System.out.println("case 5 works");
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
        }
    }



}
