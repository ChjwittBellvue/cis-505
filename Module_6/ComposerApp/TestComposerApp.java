/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_6.ComposerApp;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    // Scanner to track user input
    private static Scanner keyboard = new Scanner(System.in);
    // Dao object to interact with Composer objects
    private static MemComposerDao memComposerDao = new MemComposerDao();

    /**
     * Class run method
     * 
     * @param args
     */
    public static void main(String... args) {
        // Display the menu and return user input
        Integer userInput = displayMenu();

        // Add newline for readability
        System.err.println();

        // While the user chooses to continue (does not input "4")
        while (!userInput.equals(4)) {
            if (userInput.equals(1)) { // If the user chooses to view all composers
                List<Composer> composers = memComposerDao.findAll();

                for (Composer composer : composers) {
                    System.out.println(composer);
                }

            } else if (userInput.equals(2)) { // If the user chooses to view a specific composer
                // prompt the user for the composer id
                System.out.print("  Enter an id: ");
                Integer composerId = getValidInteger();

                // Add newline for readability
                System.err.println();

                // Find the composer by the id
                Composer chosenComposer = memComposerDao.findBy(composerId);

                // If the composer exists, display that data
                if (chosenComposer != null) {
                    System.out.println(chosenComposer);
                }
            } else if (userInput.equals(3)) { // If the user chooses to add a composer
                // Prompt user for new id
                System.out.print("  Enter an id: ");
                Integer id = checkComposerIdDoesNotExist();

                // Prompt user for a name
                System.out.print("  Enter a name: ");
                String name = keyboard.next();

                // Prompt user for a genre
                System.out.print("  Enter a genre:");
                String genre = keyboard.next();

                // Set up the Composer object and add it to the composer list
                Composer newComposer = new Composer(id, name, genre);
                memComposerDao.insert(newComposer);

                // Add newline for readability
                System.err.println();
            } else { // If the user enters a value outside of 1 through 4
                System.out.println("  Invalid input, please enter only values 1 through 4");

                // Prompt the user for new input
                userInput = displayMenu();

                // Add newline for readability
                System.err.println();
            }
            // Prompt the user for new input
            userInput = displayMenu();

            // Add newline for readability
            System.err.println();
        }

        // Exit message
        System.out.println("  Thank you for using the Composer Application."
                + System.lineSeparator());
    } // end main

    /*
     * Method to display the menu
     */
    private static Integer displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("  MENU OPTIONS" + System.lineSeparator());
        sb.append("    1. View Composers" + System.lineSeparator());
        sb.append("    2. Find Composer" + System.lineSeparator());
        sb.append("    3. Add Composer" + System.lineSeparator());
        sb.append("    4. Exit" + System.lineSeparator() + System.lineSeparator());
        sb.append("  Please choose an option: ");

        System.out.print(sb.toString());

        // Validate integer before returning
        return getValidInteger();
    } // end displayMenu

    /**
     * Checks user input for a valid Integer and prompts them to re-enter if it is
     * not
     * 
     * @return Integer
     */
    private static Integer getValidInteger() {
        boolean isValidInteger = false;
        Integer input = 0;

        // While user input is not an Integer
        while (!isValidInteger) {
            if (keyboard.hasNextInt()) { // If the input is valid
                input = keyboard.nextInt();
                isValidInteger = true;
            } else { // If the input is invalid
                System.out.print("\n  Error! Invalid integer value. Please enter a new value: ");
            }
            keyboard.nextLine();
        }

        return input;
    }

    /**
     * Protects data integrity by checking if an id is already taken
     * 
     * @return Integer - new id
     */
    private static Integer checkComposerIdDoesNotExist() {
        // Validate Integer before continuing
        Integer userInput = getValidInteger();
        boolean isValid = true;

        // Get all the composers in the list
        List<Composer> composers = memComposerDao.findAll();

        // Run at least once
        do {
            isValid = true;

            // Check each composer for the id submitted by the user
            for (Composer composer : composers) {
                if (composer.getId().equals(userInput)) { // If the id is found in the list, prompt the user to enter a
                                                          // different one

                    System.out.print(System.lineSeparator() + "  That id is already used, please enter another: ");
                    isValid = false;
                    userInput = getValidInteger();
                }
            }
        } while (!isValid);

        return userInput;
    }
}
