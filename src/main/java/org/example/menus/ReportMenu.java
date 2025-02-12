package org.example.menus;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.example.service.OrdersService;
import org.example.service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReportMenu {
    public static void showMenu(Scanner scanner) {

        ProductService productService = new ProductService();
        OrdersService ordersService = new OrdersService();
        while (true) {
            System.out.println("\n==== Reporting ====");
            System.out.println("1. Generate report of all products in a given category");
            System.out.println("2. Generate report of all orders within a specific date range");
            System.out.println("3. Generate report of top-selling products");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Generating product report by category...");
                    System.out.println("Please enter the category of the product:");
                    Scanner category = new Scanner(System.in);
                    String categoryName = category.nextLine();
                    System.out.println(productService.getProductsByCategory(categoryName));
                    break;
                case 2:
                    System.out.println("Generating orders report by date range...");
                    fetchOrdersWithinDateRange(ordersService);
                    break;
                case 3:
                    System.out.println("Generating top-selling products report...");
                    topSellingProductsReport(productService);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void topSellingProductsReport(ProductService productService) {

        List<Map<String, Object>> topSellingProducts = productService.getTopSellingProducts();

        if (topSellingProducts.isEmpty()) {
            System.out.println("No sales data available.");
        } else {
            System.out.println("\n==== Top-Selling Products ====");
            for (Map<String, Object> product : topSellingProducts) {
                System.out.println(product);
            }
        }
    }

    public static void fetchOrdersWithinDateRange(OrdersService ordersService) {
        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            System.out.print("Enter start date (yyyy-MM-dd): ");
            String start_date = scanner.nextLine();
            System.out.print("Enter end date (yyyy-MM-dd): ");
            String end_date = scanner.nextLine();

            Date startDate = sdf.parse(start_date);
            Date endDate = sdf.parse(end_date);

            List<Map<String, Object>> orders = ordersService.fetchOrdersWithinDateRange(startDate, endDate);

            System.out.println("==== Orders from " + start_date + " to " + end_date + " ====");
            if (orders.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                for (Map<String, Object> order : orders) {
                    System.out.println(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

