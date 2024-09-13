package Module_4.BowlingShopApp;

public class Ball extends Product {
    private String color;

    // Constructors
    /**
     * Sets default ball
     */
    public Ball() {
        this.color = "";
    } // end default constructor

    // Accessors and Mutators
    public String getColor() {
        return color;
    } // end getColor

    public void setColor(String color) {
        this.color = color;
    } // end setColor

    /**
     * Overridden toString method displays super class product information and ball
     * information with each attribute
     * on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("  Ball Color: " + color + System.lineSeparator());
        return sb.toString();
    } // end toString
}
