/*
 * REFERENCES
 * 
 * Digital Ocean (2022, October 24). Java SimpleDateFormat - Java Date Format. Retrieved September 2, 2024, 
 *      from https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format
 * 
 * Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_3.CustomerApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    // Attributes
    private double balance = 200;

    /**
     * Returns account balance
     * 
     * @return double
     */
    public double getBalance() {
        return balance;
    } // end getBalance

    /**
     * Increases the balance amount by the parameter amount.
     * 
     * @param amt
     */
    public void deposit(double amt) {
        balance = balance + amt;
    } // end deposit

    /**
     * Decreases the balance amount by the parameter amount if the account contains
     * enough money.
     * 
     * @param amt
     */
    public void withdraw(double amt) {
        // Check if customer has enough funds
        if (amt <= balance) {
            balance = balance - amt;
        } else { // Display message informing the user that they don't have enough funds
            System.out.println("  You do not have enough in your account to withdraw that amount.");
        }
    } // end withdraw

    /**
     * Displays the menu for account operations
     * NOTE: Does not handle the actual operations, just displays the menu to the
     * console.
     */
    public void displayMenu() {
        System.out.println("  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("    Enter option>: ");
    } // end displayMenu

    /**
     * Returns the current date in "MM-dd-yyyy" format.
     * 
     * @return Date
     */
    public String getTransactionDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return simpleDateFormat.format(new Date());
    }

}
