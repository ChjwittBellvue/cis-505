/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

public class Product {
    // Attributes
    private String code;
    private String description;
    private double price;

    // Constructors
    /**
     * Sets default product
     */
    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0;
    } // end default constructor

    // Accessors and Mutators
    public String getCode() {
        return code;
    } // end getCode

    public void setCode(String code) {
        this.code = code;
    } // end setCode

    public String getDescription() {
        return description;
    } // end getDescription

    public void setDescription(String description) {
        this.description = description;
    } // end setDescription

    public double getPrice() {
        return price;
    } // end getPrice

    public void setPrice(double price) {
        this.price = price;
    } // end setPrice

    /**
     * Overridden toString method displays product information with each attribute
     * on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Product Code: " + code + System.lineSeparator());
        sb.append("  Description: " + description + System.lineSeparator());
        String formattedPrice = String.format("$%,6.2f", price);
        sb.append("  Price: " + formattedPrice + System.lineSeparator());
        return sb.toString();
    } // end toString

}
