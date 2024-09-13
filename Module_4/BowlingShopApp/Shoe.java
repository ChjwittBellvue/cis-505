/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

public class Shoe extends Product {
    private double size;

    // Constructors
    /**
     * Sets default shoe
     */
    public Shoe() {
        this.size = 0;
    } // end default constructor

    // Accessors and Mutators
    public double getSize() {
        return size;
    } // end getSize

    public void setSize(double size) {
        this.size = size;
    } // end setSize

    /**
     * Overridden toString method displays super class product information and shoe
     * information with each attribute
     * on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("  Size: " + size + System.lineSeparator());
        return sb.toString();
    } // end toString
}
