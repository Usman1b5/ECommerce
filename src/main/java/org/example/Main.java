package org.example;

import org.example.menus.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("hello");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Product Management");
            System.out.println("2. Category Management");
            System.out.println("3. Order Management");
            System.out.println("4. Customer Management");
            System.out.println("5. Reporting");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ProductMenu.showMenu(scanner);
                    break;
                case 2:
                    CategoryMenu.showMenu(scanner);
                    break;
                case 3:
                    OrderMenu.showMenu(scanner);
                    break;
                case 4:
                    CustomerMenu.showMenu(scanner);
                    break;
                case 5:
                    ReportMenu.showMenu(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the application...");
                    System.out.println("GDOD BYE");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}