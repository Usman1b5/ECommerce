package org.example.menus;

import org.example.service.ProductService;

import java.util.Scanner;

public class ProductMenu {
    public static void showMenu(Scanner scanner) {

        while (true) {
            System.out.println("\n==== Product Management ====");
            System.out.println("1. Add new product");
            System.out.println("2. View all products");
            System.out.println("3. Search products by name or category");
            System.out.println("4. Update product details");
            System.out.println("5. Remove products");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            ProductService productService = new ProductService();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new product...");
                    System.out.println("please enter the name of product:");
                    Scanner name = new Scanner(System.in);
                    String productName = name.nextLine();

                    System.out.println("please enter the description of product:");
                    Scanner description = new Scanner(System.in);
                    String productDesc = description.nextLine();

                    System.out.println("please enter the price of product:");
                    Scanner price = new Scanner(System.in);
                    float productPrice = price.nextFloat();

                    System.out.println("please enter the quantity of product:");
                    Scanner quantity = new Scanner(System.in);
                    int productQuantity = quantity.nextInt();

                    System.out.println("please enter the category id:");
                    Scanner categoryId = new Scanner(System.in);
                    int category_id = categoryId.nextInt();

                    productService.addProduct(productName, productDesc, productPrice, productQuantity, category_id);
                    break;
                case 2:
                    System.out.println("Listing all products...");
                    System.out.println(productService.getProduct());
                    break;
                case 3:
                    System.out.println("Searching products...");
                    System.out.println("please enter name of product:");
                    Scanner prod_name = new Scanner(System.in);
                    String prodName = prod_name.nextLine();

                    System.out.println("please enter categoryId:");
                    Scanner catId = new Scanner(System.in);
                    int category_Id = catId.nextInt();

                    System.out.println(productService.getProductByNameOrCategory(prodName, category_Id));
                    break;
                case 4:
                    System.out.println("Updating product details...");
                    System.out.println("please update price:");
                    Scanner product_price = new Scanner(System.in);
                    float prod_price = product_price.nextFloat();

                    System.out.println("please update quantity:");
                    Scanner product_quantity = new Scanner(System.in);
                    int prod_quantity = product_quantity.nextInt();

                    System.out.println("please update description:");
                    Scanner product_description = new Scanner(System.in);
                    String prod_desc = product_description.nextLine();

                    System.out.println("please enter productId:");
                    Scanner productId = new Scanner(System.in);
                    int prod_id = productId.nextInt();

                    productService.updateProduct(prod_price, prod_quantity, prod_desc, prod_id);
                    System.out.println("Product Updated Successfully...");
                    break;
                case 5:
                    System.out.println("Removing product...");
                    System.out.println("Please enter product_id to remove the result:");
                    Scanner prodId = new Scanner(System.in);
                    int product_Id = prodId.nextInt();
                    productService.deleteProduct(product_Id);

                    System.out.println("Product Removed Successfully...");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
