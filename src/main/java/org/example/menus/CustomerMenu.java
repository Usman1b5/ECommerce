package org.example.menus;

import org.example.service.CustomerService;

import java.math.BigInteger;
import java.util.Scanner;

public class CustomerMenu {
    public static void showMenu(Scanner scanner) {

        CustomerService customerService = new CustomerService();
        while (true) {
            System.out.println("\n==== Customer Management ====");
            System.out.println("1. Add new customer");
            System.out.println("2. Search customers by name");
            System.out.println("3. View all customers");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new customer...");
                    System.out.println("please enter name of customer:");
                    Scanner name = new Scanner(System.in);
                    String custName = name.nextLine();

                    System.out.println("please enter the address of customer:");
                    Scanner address = new Scanner(System.in);
                    String custAddress = address.nextLine();

                    System.out.println("please enter phone No of customer:");
                    Scanner phoneNo = new Scanner(System.in);
                    BigInteger custPhoneNo = phoneNo.nextBigInteger();

                    customerService.addCustomer(custName, custAddress, custPhoneNo);
                    break;
                case 2:

                    System.out.println("Searching for customer...");
                    System.out.println("please enter name of customer:");
                    Scanner CustName = new Scanner(System.in);
                    String cust_Name = CustName.nextLine();
                    System.out.println("Data against Above cust_name:");
                    System.out.println(customerService.getCustomersByName(cust_Name));

                    break;
                case 3:
                    System.out.println("Listing all customers...");
                    System.out.println(customerService.getCustomer());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}