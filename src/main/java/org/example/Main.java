package org.example;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.configuration.DatabaseConfig;
import org.example.dao.CategoryDAO;
import org.example.dao.ProductDAO;
import org.example.menus.*;
import org.example.models.Category;
import org.example.models.OrderItem;
import org.example.models.Orders;
import org.example.models.Product;
import org.example.service.CategoryService;
import org.example.service.CustomerService;
import org.example.service.OrdersService;
import org.example.service.ProductService;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
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


//          CategoryService categoryService = new CategoryService();
//        System.out.println(categoryService.getCategory());

//        ProductService productService = new ProductService();
//        System.out.println(productService.getProduct());
//



//        System.out.println("fetched successfully");

//        ProductService productService = new ProductService();

//
//        System.out.println("updated successfully!!!!!!!!!!!!!!!!!!!!!");

//        ProductService productService = new ProductService();
//


        /// ///////////// CUSTOMER QUERIES STARTS FROM HERE
//
//        CustomerService customerService = new CustomerService();

        /// /////////////// orders query starts from here


//        OrdersService orderService = new OrdersService();
//        System.out.println(orderService.viewOrderDetails());
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("\n==== Order Management ====");
//            System.out.println("1. Create New Order");
//            System.out.println("2. View Order by ID");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//
//            int choice = scanner.nextInt();
//


//            } else if (choice == 3) {
//                System.out.println("Exiting...");
//                break;
//            } else {
//                System.out.println("Invalid option. Try again.");
//            }
//        }
//
//        scanner.close();



        /// //////        FOREIGN KEY PROBLEM IN CANCELORDER FUNCTION ///////////////////////////////

    }
}
