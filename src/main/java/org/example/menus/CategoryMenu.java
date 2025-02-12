package org.example.menus;

import org.example.service.CategoryService;

import java.util.Scanner;

public class CategoryMenu {
    public static void showMenu(Scanner scanner) {
        CategoryService categoryService = new CategoryService();
        while (true) {
            System.out.println("\n==== Category Management ====");
            System.out.println("1. Add new category");
            System.out.println("2. View all categories");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new category...");

                    System.out.println("please enter the name of category:");
                    Scanner name = new Scanner(System.in);
                    String categoryName = name.nextLine();

                    System.out.println("please enter the description of category:");
                    Scanner description = new Scanner(System.in);
                    String categoryDesc = description.nextLine();

                    categoryService.addCategory(categoryName, categoryDesc);
                    break;
                case 2:
                    System.out.println("Listing all categories...");
                    System.out.println(categoryService.getCategory());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
