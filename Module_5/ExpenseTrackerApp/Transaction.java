/*
 *  REFERENCES
 * 
 * Pankaj (2022, October 24). Java SimpleDateFormat - Java Date Format. Retrieved September 14, 2024, 
 * from https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */

package Module_5.ExpenseTrackerApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    // Set up date format
    final private String DATE_FORMAT = "MM-dd-yyyy";
    final private SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    // Attributes
    private String date;
    private String description;
    private double amount;

    // constructors
    public Transaction() {
        this.date = formatter.format(new Date());
    } // end default constructor

    public Transaction(String description, double amount) {
        this.date = formatter.format(new Date());
        this.description = description;
        this.amount = amount;
    } // end full constructor

    public Transaction(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    } // end full constructor

    // Accessors and Mutators
    public String getDate() {
        return date;
    } // end getDate

    public void setDate(String date) {
        this.date = date;
    } // setDate

    public String getDescription() {
        return description;
    } // getDescription

    public void setDescription(String description) {
        this.description = description;
    } // setDescription

    public double getAmount() {
        return amount;
    } // getAmount

    public void setAmount(double amount) {
        this.amount = amount;
    } // setAmount

    /**
     * Overridden toString method displays transaction information with each
     * attribute on its own line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Date: " + date + System.lineSeparator());
        sb.append("  Description: " + description + System.lineSeparator());
        String formattedPrice = String.format("$%,6.2f", amount);
        sb.append("  Amount: " + formattedPrice + System.lineSeparator());
        return sb.toString();
    } // end toString
}
