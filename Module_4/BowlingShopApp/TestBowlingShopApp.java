/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

import java.util.Scanner;

public class TestBowlingShopApp {

    // Class Attributes
    private static Scanner keyboard = new Scanner(System.in);
    private static GenericQueue<Product> products = new GenericQueue<Product>();

    /**
     * Runs the Bowling Shop App
     */
    public static void main(String... args) {
        // Welcome user to the app and display the menu
        System.out.println("  Welcome to the Bowling Shop App." + System.lineSeparator());
        String userInput = displayMenu();

        // Accept input and display the menu until the user selects "x"
        while (!userInput.equals("x")) {
            // Display the products based on user input
            products = ProductDB.getProducts(userInput);
            // Check if the product list has items
            if (products.size() > 0) {
                // Product listing separator for readability
                System.out.println(System.lineSeparator() + "  --Product Listing--" + System.lineSeparator());

                // Remove the products from the queue and display the contents of each item
                while (products.size() > 0) {
                    System.out.println(products.dequeue().toString());
                }

            } else { // If the product list has no items, display a message saying no products exist
                     // for that option
                System.out.println(System.lineSeparator() + "  No Products for that option" + System.lineSeparator());
            }

            // Update user input and display the menu again
            userInput = displayMenu();
        }

        // End message for the user
        System.out.println(System.lineSeparator() + "  Thank you for using the Bowling Shop App.");
    } // end main

    /**
     * Display the menu and accept user input
     * 
     * @return String - userInput
     */
    public static String displayMenu() {
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit" + System.lineSeparator());
        System.out.print("  Please choose an option: ");

        return keyboard.nextLine();
    }
}
