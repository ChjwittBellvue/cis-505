/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_5.ExpenseTrackerApp;

import java.util.Scanner;

public class ValidatorIO {
    /**
     * Validates user input as an integer
     * 
     * @param sc     - Scanner sent from main class
     * @param prompt - User prompt
     * @return Integer - User input
     */
    public static Integer getInt(Scanner sc, String prompt) {
        Integer input = 0;
        boolean isValid = false;

        // Loop until the user provides an Integer
        while (!isValid) {
            System.out.print(prompt);

            // If the input is an Integer, flip the isValid flag and return the Integer
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        }
        return input;
    } // end getInteger

    /**
     * Validates user input as an double
     * 
     * @param sc     - Scanner sent from main class
     * @param prompt - User prompt
     * @return Double - User input
     */
    public static Double getDouble(Scanner sc, String prompt) {
        Double input = (double) 0;
        boolean isValid = false;

        // Loop until the user provides a Double
        while (!isValid) {
            System.out.print(prompt);

            // If the input is an Double, flip the isValid flag and return the Double
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\n  Error! Invalid double value.");
            }
            sc.nextLine();
        }
        return input;
    } // end getDouble

    /**
     * Writes prompt to console and returns the next String input
     * 
     * @param sc     - Scanner sent from main class
     * @param prompt - User prompt
     * @return String - User input
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        return input;
    } // end getString

}
