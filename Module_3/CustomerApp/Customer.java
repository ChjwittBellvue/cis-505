/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_3.CustomerApp;

public class Customer {
    // Attributes
    private String name;
    private String address;
    private String city;
    private String zip;

    // Constructors
    /**
     * Sets default user, unassociated with an id in CustomerDB.
     */
    public Customer() {
        this.name = "Peter Parker";
        this.address = "123 Feast Circle";
        this.city = "Chicago";
        this.zip = "12345";
    } // end default constructor

    /**
     * Full argument constructor for Customer.
     * 
     * @param name    - Customer Name
     * @param address - Customer Address
     * @param city    - Customer City
     * @param zip     - Customer Zip
     */
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    } // end full argument constructor

    // Accessors
    public String getName() {
        return name;
    } // end getName

    public String getAddress() {
        return address;
    } // end getAddress

    public String getCity() {
        return city;
    } // end getCity

    public String getZip() {
        return zip;
    } // end getZip

    /**
     * Overridden toString method displays customer information with each attribute
     * on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Name: " + name + System.lineSeparator());
        sb.append("  Address: " + address + System.lineSeparator());
        sb.append("  City: " + city + System.lineSeparator());
        sb.append("  Zip: " + zip + System.lineSeparator());
        return sb.toString();
    } // end toString

}
