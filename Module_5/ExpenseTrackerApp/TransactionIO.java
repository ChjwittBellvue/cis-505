/*
 *  REFERENCES
 * 
 * Oracle (n.d.). Class PrintWriter. Docs.Oracle.com. Retrieved September 14, 2024, from https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
 * 
 * Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all rights reserved.
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */

package Module_5.ExpenseTrackerApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    // Set up file
    final private static String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    /**
     * Method to insert transactions to the expense file
     * 
     * @param transactions
     * @throws IOException
     */
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;

        if (file.exists()) { // If the file exists, append to it
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        } else { // If the does not exist, create it and write to it with future operations
            output = new PrintWriter(FILE_NAME);
        }

        // Write each transaction to console
        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }

        // Close the writer session
        output.close();
    } // end bulkInsert

    // Method to find all Transactions in the expense file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (file.exists()) {
            Scanner input = new Scanner(file);

            // Continue creating Transaction objects while there are objects in the file
            while (input.hasNext()) {

                // Assign sets of 3 input to their proper Transaction values
                String date = input.next();
                String description = input.next();
                double amount = Double.valueOf(input.next());

                // Add the transaction to the list
                transactions.add(new Transaction(date, description, amount));
            }

            input.close();
        } else { // If there is no file, inform the user that there are no transactions
            System.out.println("  No transactions found");
        }

        // Return the list of Transactions
        return transactions;
    } // end findAll
}
