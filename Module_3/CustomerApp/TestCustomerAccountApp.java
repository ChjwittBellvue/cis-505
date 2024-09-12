/*
 *  REFERENCES
 * 
 * Udemy (2013, December 1). Java While Loops, Do-While Loops, and Infinite Loops. Retrieved September 2, 2024, 
 *  from https://blog.udemy.com/java-while-loop/
 *  
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_3.CustomerApp;

import java.util.Scanner;

public class TestCustomerAccountApp {

    // Class Attributes
    private static Scanner keyboard = new Scanner(System.in);
    private static Account account = new Account();
    private static Customer customer;

    /**
     * Main method runs the program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // First and last account to update range if more customers are added
        String firstAccount = "1007";
        String lastAccount = "1009";

        // Welcome the customer to the application and prompt them to enter an id
        System.out.println("  Welcome to the Customer Account App" + System.lineSeparator() + System.lineSeparator());
        System.out.print("  Enter customer ID between " + firstAccount + " and " + lastAccount + ": ");

        // Verify that an Integer can be parsed from the user input
        int customerId = verifyCustomerId(keyboard.nextLine());

        // Retrieve the customer from CustomerDB
        customer = CustomerDB.getCustomer(customerId);

        boolean customerWantsToContinue = false;
        do {
            // Display the menu for the user
            System.out.println();
            account.displayMenu();

            // Determine chosen operation and perform it
            performAccountOperation(keyboard.nextLine());

            // Prompt user to continue and update customerWantsToContinue flag
            customerWantsToContinue = promptUserToContinue();
        } while (customerWantsToContinue);

        // Display the account summary and customer information at the end of the
        // program
        displaySummary();
    } // end main

    /**
     * Determines operation to perform based on user input and displays an error
     * message if the user inputs a value without an operation assigned
     * 
     * @param userInput
     */
    private static void performAccountOperation(String userInput) {
        if (userInput.equalsIgnoreCase("D")) {
            // Deposit
            performDeposit();
        } else if (userInput.equalsIgnoreCase("W")) {
            // Withdraw
            performWithdraw();
        } else if (userInput.equalsIgnoreCase("B")) {
            // Balance
            System.out.print(System.lineSeparator() + "  Account balance: ");
            System.out.printf("$%,6.2f", account.getBalance());
            System.out.println();
        } else {
            // Display error
            System.out.println(System.lineSeparator() + "  Error: Invalid Option.");
        }
    } // end performAccountOperation

    /**
     * Performs the deposit operation
     */
    private static void performDeposit() {
        // Prompt the user to enter the deposit
        System.out.print("  Enter deposit amount: ");

        // Verify the input can be parsed to a double (ex: user can't enter a letter)
        double depositAmount = verifyDollarAmount(keyboard.nextLine());
        while (depositAmount == Double.valueOf(-1)) {
            // Retry if the user enters bad input
            System.out.print(System.lineSeparator() + "  Please re-enter deposit amount: ");
            depositAmount = verifyDollarAmount(keyboard.nextLine());
        }

        // Perform deposit
        account.deposit(depositAmount);
    } // end performDeposit

    /**
     * Performs the withdraw operation
     */
    private static void performWithdraw() {
        // Prompt the user to enter the amount to withdraw
        System.out.print("  Enter withdraw amount: ");

        // Verify the input can be parsed to a double (ex: user can't enter a letter)
        double depositAmount = verifyDollarAmount(keyboard.nextLine());
        while (depositAmount == Double.valueOf(-1)) {
            // Retry if the user enters bad input
            System.out.print(System.lineSeparator() + "  Please re-enter withdraw amount: ");
            depositAmount = verifyDollarAmount(keyboard.nextLine());
        }

        // Perform withdraw operation
        account.withdraw(depositAmount);
    } // end performWithdraw

    /**
     * Verifies that the user input can be parsed to an Integer for customer id
     * 
     * @param possibleInt - User input value, should be an int
     * @return int
     */
    private static int verifyCustomerId(String possibleInt) {
        try {
            // Try to parse the user input into an int
            return Integer.parseInt(possibleInt);
        } catch (Exception e) {
            // Return a default customer id instead of throwing an error
            return 1;
        }
    } // end verifyCustomerId

    /**
     * Verifies the user input can be parsed to a double.
     * 
     * @param possibleInt -- User input value, should be a double.
     * @return double
     */
    private static double verifyDollarAmount(String possibleInt) {
        try {
            // Attempt to parse the user input into a double
            double dollarAmount = Double.parseDouble(possibleInt);

            // Checks that the user did not enter a negative value
            if (dollarAmount >= 0) {
                return dollarAmount;
            } else {
                // Returns -1 to continue a loop to prompt the user to enter the value again
                System.out.println("  Please enter a positive value.");
                return Double.valueOf(-1);
            }
        } catch (Exception e) {
            // If the value is not parsable, continue the loop to prompt the user to enter
            // the value again
            System.out.println(
                    "  Value must be a valid dollar amount. (ex: 3.01, 5.16)");
            return Double.valueOf(-1);
        }
    } // end verifyDollarAmount

    /**
     * Prompts the user with a choice to continue working with the account.
     * 
     * @return boolean
     */
    private static boolean promptUserToContinue() {
        // Boolean value to determine if the user has entered a proper response
        boolean userResponded = false;

        // Boolean value to determine if the user wants to continue
        boolean shouldContinue = false;
        do {
            // Prompt the user to continue
            System.out.print(System.lineSeparator() + "  Continue? (y/n):");
            String continueResponse = keyboard.nextLine();

            if (continueResponse.equalsIgnoreCase("Y")) {
                // User wants to continue and proper response has been recorded
                shouldContinue = true;
                userResponded = true;
            } else if (continueResponse.equalsIgnoreCase("N")) {
                // User does not want to continue and proper response has been recorded
                shouldContinue = false;
                userResponded = true;
            } else {
                // User entered something other than Y or N and will be prompted to try again
                System.out.println("  Please input Y or N.");
            }
        } while (!userResponded);
        return shouldContinue;
    } // end promptUserToContinue

    /**
     * Displays the account summary and customer information
     */
    private static void displaySummary() {
        System.out.println(System.lineSeparator() + "  --Customer Details--");
        System.out.print(customer.toString() + System.lineSeparator());
        System.out.print("  Balance as of " + account.getTransactionDate() + " is ");
        System.out.printf("$%,6.2f", account.getBalance());
    } // end displaySummary
}
