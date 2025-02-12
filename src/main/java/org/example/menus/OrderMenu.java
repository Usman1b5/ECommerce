package org.example.menus;

import org.example.models.OrderItem;
import org.example.models.Orders;
import org.example.service.OrdersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {
    public static void showMenu(Scanner scanner) {
        OrdersService ordersService = new OrdersService();
        while (true) {
            System.out.println("\n==== Order Management ====");
            System.out.println("1. Create new order");
            System.out.println("2. View order details");
            System.out.println("3. Update order status");
            System.out.println("4. Cancel order");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating new Order");
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();

                    List<OrderItem> orderItems = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter Product ID (or -1 to stop): ");
                        int productId = scanner.nextInt();
                        if (productId == -1) break;

                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();

                        orderItems.add(new OrderItem(productId,quantity));

                        ordersService.createOrder(customerId, orderItems);

                        System.out.println("Order Created Successfully...");
                    }
                    break;
                case 2:
                    System.out.println("Enter the orderId: ");
                    int orderId = scanner.nextInt();
                    Orders order = ordersService.getOrderById(orderId);

                    if (order != null) {
                        System.out.println("Order Details: " + order);
                    } else {
                        System.out.println("Order not found.");
                    }
                    System.out.println("Viewing order details...");
                    break;
                case 3:
                    System.out.println("Updating order status...");
                    System.out.println("please enter order_id:");
                    Scanner id = new Scanner(System.in);
                    int order_Id = id.nextInt();
                    System.out.println("please enter order status against above id:");
                    Scanner status = new Scanner(System.in);
                    String orderStatus = status.nextLine();

                    ordersService.updateOrderStatus(orderStatus, order_Id);
                    break;


                case 4:
                    System.out.println("Canceling order...");
                    System.out.println("please enter order id to cancel the order:");
                    Scanner cancelOrder = new Scanner(System.in);
                    int deleteOrder = cancelOrder.nextInt();
                    ordersService.cancelOrder(deleteOrder);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}