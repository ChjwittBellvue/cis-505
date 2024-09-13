/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

public class ProductDB {

    /**
     * Returns products based on user input
     * 
     * @param code - code used to determine which product should be added to the
     *             queue
     * @return GenericQueue<Product>
     */
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> queue = new GenericQueue<Product>();
        // If the user chooses "b"
        if (code.equals("b")) {
            // Create Ball objects
            Ball ball1 = createBall("BL1", "The Pin Decimator", 120.99, "Blue");
            Ball ball2 = createBall("BL2", "Generic Ball", 50.25, "White");
            Ball ball3 = createBall("BL3", "Hurricane", 200.25, "Silver");
            Ball ball4 = createBall("BL4", "The Pin Decimator", 120.99, "Red");
            Ball ball5 = createBall("BL5", "Highwind", 300.00, "Silver and Blue");

            // Add ball objects to the queue
            queue.enqueue(ball1);
            queue.enqueue(ball2);
            queue.enqueue(ball3);
            queue.enqueue(ball4);
            queue.enqueue(ball5);

            // Return the queue
            return queue;

            // If the user chooses "s"
        } else if (code.equals("s")) {
            Shoe shoe1 = createShoe("S1", "Dancin' Shoes", 60.99, 7);
            Shoe shoe2 = createShoe("S2", "Clown Shoes", 25.99, 8);
            Shoe shoe3 = createShoe("S3", "Lane Sprinters", 75.50, 10);
            Shoe shoe4 = createShoe("S4", "Impossible Shoes Co.", 150.76, 18);
            Shoe shoe5 = createShoe("S5", "Taps", 80.76, 13);

            queue.enqueue(shoe1);
            queue.enqueue(shoe2);
            queue.enqueue(shoe3);
            queue.enqueue(shoe4);
            queue.enqueue(shoe5);

            return queue;

            // If the user chooses" a"
        } else if (code.equals("a")) {
            Bag bag1 = createBag("BA1", "Small ball bag", 50.00, "Single Ball");
            Bag bag2 = createBag("BA2", "Small ball bag with side pockets", 65.00, "Single Ball");
            Bag bag3 = createBag("BA3", "Medium ball bag with side pockets", 80.00, "Double Ball");

            queue.enqueue(bag1);
            queue.enqueue(bag2);
            queue.enqueue(bag3);

            return queue;
        } else {
            return new GenericQueue<Product>();
        }
    }

    private static Ball createBall(String productCode, String description, double price, String color) {
        Ball ball = (Ball) setProductData(productCode, description, price);
        ball.setColor(color);

        return ball;
    }

    private static Shoe createShoe(String productCode, String description, double price, int size) {
        Shoe shoe = (Shoe) setProductData(productCode, description, price);
        shoe.setSize(7);

        return shoe;
    }

    private static Bag createBag(String productCode, String description, double price, String type) {
        Bag bag = (Bag) setProductData(productCode, description, price);
        bag.setType(type);

        return bag;
    }

    private static Product setProductData(String productCode, String description, double price) {
        Product product = new Product();
        product.setCode(productCode);
        product.setDescription(description);
        product.setPrice(price);

        return product;
    }

}
