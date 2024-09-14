/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

public class Bag extends Product {
    private String type;

    // Constructors
    /**
     * Sets default bag
     */
    public Bag() {
        this.type = "";
    } // end default constructor

    // Accessors and Mutators
    public String getType() {
        return type;
    } // end getType

    public void setType(String type) {
        this.type = type;
    } // end setType

    /**
     * Overridden toString method displays super class product information and bag
     * information with each attribute
     * on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("  Type: " + type + System.lineSeparator());
        return sb.toString();
    } // end toString
}
