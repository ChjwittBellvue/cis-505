/*
 *  REFERENCES
 * 
 * Singh, D. (2023, March 18). Generics in Java. Retrieved September 14, 2024, from https://www.geeksforgeeks.org/generics-in-java/
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
        if (code.equals("b")) { // If the user chooses "b"
            GenericQueue<Product> balls = new GenericQueue<Product>();
            // Create Ball objects
            Ball ball1 = createBall("BL1", "The Pin Decimator", 120.99, "Blue");
            Ball ball2 = createBall("BL2", "Generic Ball", 50.25, "White");
            Ball ball3 = createBall("BL3", "Hurricane", 200.25, "Silver");
            Ball ball4 = createBall("BL4", "The Pin Decimator", 120.99, "Red");
            Ball ball5 = createBall("BL5", "Highwind", 300.00, "Silver and Blue");

            // Add ball objects to the queue
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);

            // Return the queue
            return balls;

        } else if (code.equals("s")) { // If the user chooses "s"
            GenericQueue<Product> shoes = new GenericQueue<Product>();

            Shoe shoe1 = createShoe("S1", "Dancin' Shoes", 60.99, 7);
            Shoe shoe2 = createShoe("S2", "Clown Shoes", 25.99, 8);
            Shoe shoe3 = createShoe("S3", "Lane Sprinters", 75.50, 10);
            Shoe shoe4 = createShoe("S4", "Impossible Shoes Co.", 150.76, 18);
            Shoe shoe5 = createShoe("S5", "Taps", 80.76, 13);

            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);

            return shoes;

        } else if (code.equals("a")) { // If the user chooses" a"
            GenericQueue<Product> bags = new GenericQueue<Product>();

            Bag bag1 = createBag("BA1", "Small ball bag", 50.00, "Single Ball");
            Bag bag2 = createBag("BA2", "Small ball bag with side pockets", 65.00, "Single Ball");
            Bag bag3 = createBag("BA3", "Medium ball bag with side pockets", 80.00, "Double Ball");

            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);

            return bags;

        } else { // If the user chooses anything else
            return new GenericQueue<Product>();
        }
    }

    /**
     * Creates a ball object
     * 
     * @param productCode
     * @param description
     * @param price
     * @param color
     * @return Ball
     */
    private static Ball createBall(String productCode, String description, double price, String color) {
        Ball ball = new Ball();
        ball.setCode(productCode);
        ball.setDescription(description);
        ball.setPrice(price);
        ball.setColor(color);

        return ball;
    }

    /**
     * Creates a Shoe object
     * 
     * @param productCode
     * @param description
     * @param price
     * @param size
     * @return Shoe
     */
    private static Shoe createShoe(String productCode, String description, double price, int size) {
        Shoe shoe = new Shoe();
        shoe.setCode(productCode);
        shoe.setDescription(description);
        shoe.setPrice(price);
        shoe.setSize(7);

        return shoe;
    }

    /**
     * Creates a Bag object
     * 
     * @param productCode
     * @param description
     * @param price
     * @param type
     * @return Bag
     */
    private static Bag createBag(String productCode, String description, double price, String type) {
        Bag bag = new Bag();
        bag.setCode(productCode);
        bag.setDescription(description);
        bag.setPrice(price);
        bag.setType(type);

        return bag;
    }

}
