package Module_4.BowlingShopApp;

import java.util.Scanner;

public class TestBowlingShopApp {

    // Class Attributes
    private static Scanner keyboard = new Scanner(System.in);
    private static GenericQueue<Product> products = new GenericQueue<Product>();

    public static void main(String... args) {
        System.out.println("  Welcome to the Bowling Shop App." + System.lineSeparator());
        String userInput = displayMenu();

        while (!userInput.equals("x")) {
            products = ProductDB.getProducts(userInput);
            if (products.size() > 0) {
                System.out.println(System.lineSeparator() + "  --Product Listing--" + System.lineSeparator());
                while (products.size() > 0) {
                    products.dequeue();
                }
            } else {
                System.out.println(System.lineSeparator() + "  No Products for that option" + System.lineSeparator());
            }
            userInput = displayMenu();
        }

        System.out.println(System.lineSeparator() + "  Thank you for using the Bowling Shop App.");
    }

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
