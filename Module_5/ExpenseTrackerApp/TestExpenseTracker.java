/*
 *  REFERENCES
 * 
 *  Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all rights reserved.
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_5.ExpenseTrackerApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    // Scanner to track user input
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Main class for running Expense Tracker
     * 
     * @throws IOException
     */
    public static void main(String... args) throws IOException {
        // Welcome message for the user
        System.out.println("  Welcome to the Expense Tracker." + System.lineSeparator());

        // Flag to cover whether the user wants to continue using the program
        boolean allOperationsFinished = false;

        // Unless allOperationsFinished is true, user will continue using the
        // application
        while (!allOperationsFinished) {
            // Validate user input and add newline for readability
            Integer userInput = ValidatorIO.getInt(keyboard, displayMenu());
            System.out.println();

            if (userInput == 1) { // If the user input is 1
                // Get the transactions written to the file
                ArrayList<Transaction> transactions = TransactionIO.findAll();

                // Write each transaction to console
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }

            } else if (userInput == 2) { // If the user input is 2
                // Flag to continue adding to expense file
                String c = "y";
                ArrayList<Transaction> transactions = new ArrayList<>();

                while (c.equalsIgnoreCase("Y")) {
                    // User inputs transaction description
                    String description = ValidatorIO.getString(keyboard, "  Enter the description: ");

                    // User inputs transaction amount
                    double amount = ValidatorIO.getDouble(keyboard, "\n  Enter the amount: ");

                    // Create Transaction object and add it to the list
                    Transaction transaction = new Transaction(description, amount);
                    transactions.add(transaction);

                    // Prompt the user to determine if they want to add another transaction
                    c = ValidatorIO.getString(keyboard, "\n  Would you like to add another transaction? (y/n): ");

                    // Newline for readability
                    System.out.println();
                }

                // Catch exceptions based on file IO errors, call bulkInsert if no errors occur
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\n  Exception: " + e.getMessage());
                }

            } else if (userInput == 3) { // If the user input is 3
                double totalExpenses = 0;

                // Get transactions from the expense file
                ArrayList<Transaction> transactions = TransactionIO.findAll();

                // Cycle through available transactions and add each expense to the total
                for (Transaction thisTransaction : transactions) {
                    totalExpenses = totalExpenses + thisTransaction.getAmount();
                }

                // Display total expenses
                System.out.print("  Your total monthly expense is ");
                String formattedTotal = String.format("$%,6.2f", totalExpenses);
                System.out.println(formattedTotal + System.lineSeparator());
            }

            // Flag to capture user input
            String userContinueDecision;
            do {
                userContinueDecision = ValidatorIO.getString(keyboard, "  Would you like to continue? (y/n): ");
                System.out.println();
                if (userContinueDecision.equalsIgnoreCase("Y")) { // If user enters "Y"
                    // Flag indicates application should continue
                    allOperationsFinished = false;
                } else if (userContinueDecision.equalsIgnoreCase("N")) { // If user enters "N"
                    // Flag indicates application should end
                    allOperationsFinished = true;
                } else {
                    // If the user enters invalid input
                    System.out.println("  Invalid choice, please enter 'y' or 'n'" + System.lineSeparator());
                }
            } while (!(userContinueDecision.equalsIgnoreCase("Y") || userContinueDecision.equalsIgnoreCase("N")));
        }

        // Exit message
        System.out.println("  Thank you for using the Expense Tracker.");
    } // end main

    /*
     * Method to display the menu
     */
    public static String displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("  MENU OPTIONS" + System.lineSeparator());
        sb.append("    1. View Transactions" + System.lineSeparator());
        sb.append("    2. Add Transactions" + System.lineSeparator());
        sb.append("    3. View Expense" + System.lineSeparator() + System.lineSeparator());
        sb.append("  Please choose an option: ");

        return sb.toString();
    } // end displayMenu
}
