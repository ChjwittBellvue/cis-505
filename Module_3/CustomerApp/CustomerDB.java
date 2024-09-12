/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_3.CustomerApp;

public class CustomerDB {
    /**
     * Determines which customer to return by matching the id to user input
     * 
     * @param id - Customer id supplied by the user
     * @return Customer
     */
    public static Customer getCustomer(Integer id) {
        if (id == 1007) {
            return new Customer("Miles Morales", "1111 S. Ave", "New York", "11111");
        } else if (id == 1008) {
            return new Customer("Tony Stark", "2222 Avenger Dr.", "Omaha", "22222");
        } else if (id == 1009) {
            return new Customer("Wade Wilson", "3333 XForce St.", "Kansas City", "33333");
        } else {
            return new Customer();
        }
    } // end getCustomer
}
