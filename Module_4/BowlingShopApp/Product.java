/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_4.BowlingShopApp;

public class Product {
    // Attributes
    private String productCode;
    private String description;
    private double price;

    // Constructors
    /**
     * Sets default user, unassociated with an id in CustomerDB.
     */
    public Product() {
        this.productCode = "";
        this.description = "";
        this.price = 0;
    } // end default constructor

    // Accessors and Mutators
    public String getProductCode() {
        return productCode;
    } // end getProductCode

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    } // end setProductCode

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
        sb.append("  Product Code: " + productCode + System.lineSeparator());
        sb.append("  Description: " + description + System.lineSeparator());
        sb.append("  Price: $" + price + System.lineSeparator());
        return sb.toString();
    } // end toString

}
