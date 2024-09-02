/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_2.TeamApp;

import java.util.Scanner;

// Test Class for Team.java
public class TestSportsTeamApp {
    // Initialize Scanner
    private static Scanner keyboard = new Scanner(System.in);

    // Main Method
    public static void main(String[] args) {
        // Boolean used to keep track of whether the user wants to enter more teams.
        boolean userWantsToContinue = true;

        // This loop gives users the ability to continue entering teams
        while (userWantsToContinue) {
            // Initialize the team using user input.
            Team team = new Team(promptForTeamName());

            // Prompt the user for players
            String playerListString = promptForPlayers();

            // Add the players to the team using playerListString
            team = addPlayersToTeam(team, playerListString);

            // Display the team summary
            displayTeamSummary(team);

            // Prompt the user for another team
            System.out.print("  Would you like to enter another team? (y/n): ");
            userWantsToContinue = promptForContinue();

            // Added for readability
            System.out.println("--------");
        }

        // Application sign off message
        System.out.println("  ********************************");
        System.out.println("  Thank you for using the Team App");
        System.out.println("  ********************************");

    } // end main

    /**
     * Prompts the user to enter a team name and takes user input from the keyboard
     * 
     * @return String teamName
     */
    private static String promptForTeamName() {
        System.out.print("  Enter a team name: ");
        String teamName = keyboard.nextLine();
        while (teamName.isEmpty()) {
            System.out.print("  Your team needs a name, please enter a team name: ");
            teamName = keyboard.nextLine();
        }
        return teamName;
    }// end promptForTeamName

    /**
     * Prompts the user to enter player names and takes user input from the keyboard
     * 
     * @return String playerListString
     */
    private static String promptForPlayers() {
        // Prompt user for players and populate player array
        displayPlayerEntryPrompt();
        String playerListString = keyboard.nextLine();

        /*
         * If the list contains a space, prompt the user for a list without the space
         * until they provide one
         */
        while (playerListString.contains(" ")) {
            if (playerListString.contains(" ")) {
                System.out.println(
                        System.lineSeparator() + "  INVALID LIST FORMAT: Please try list again without spaces.");
            }

            displayPlayerEntryPrompt();
            playerListString = keyboard.nextLine();
        }

        // Return the player list
        return playerListString;
    } // end promptForPlayers

    /**
     * Used to explain the player list format to the user separated into its own
     * method to be called multiple times.
     */
    private static void displayPlayerEntryPrompt() {
        System.out.println("  Enter player first names as a list with no spaces, separated by commas:");
        System.out.print("    (Example: player1,player2,player3): ");
    }

    /*
     * Prompts the user to continue
     * 
     * @return boolean
     */
    private static boolean promptForContinue() {
        String wantsToContinue = keyboard.nextLine();
        while (!(wantsToContinue.equalsIgnoreCase("Y") || wantsToContinue.equalsIgnoreCase("N"))) {
            System.out.print("  " + wantsToContinue + " is not a valid input, please type 'y' or 'n': ");
            wantsToContinue = keyboard.nextLine();
        }
        if (wantsToContinue.equalsIgnoreCase("N")) {
            return false;
        } else {
            return true;
        }
    } // end promptForContinue

    /**
     * Adds players to Team object by splitting the input string on ','. If the
     * player list exceeds the array size, the method will fill the array and ignore
     * the rest of the list.
     * 
     * @param team
     * @param playerListString
     * @return Team
     */
    private static Team addPlayersToTeam(Team team, String playerListString) {
        try {
            for (String playerName : playerListString.split(",")) {
                if (playerName != "") {
                    team.addPlayer(playerName);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    System.lineSeparator()
                            + "  NOTE: Teams can only have up to 20 players, the first 20 in the list were added.");
            return team;
        }
        return team;
    } // end addPlayersToTeam

    /**
     * Displays the team summary after team name and players are added.
     * 
     * @param team
     */
    private static void displayTeamSummary(Team team) {
        System.out.println(System.lineSeparator() + "  --Team Summary--");
        System.out.println(System.lineSeparator() + "  Number of players on the team: " + team.getPlayerCount());
        if (team.getPlayerCount() > 0) {
            System.out.println("  Players on the team: " + createTeamList(team));
        } else {
            System.out.println("  Players on the team: There are no players currently on this team."
                    + System.lineSeparator() + System.lineSeparator());
        }
    } // end displayTeamSummary

    /*
     * Formats the array into a readable list for the summary.
     * 
     * @Return String playerList
     */
    private static String createTeamList(Team team) {
        StringBuilder sb = new StringBuilder();
        String[] playerArray = team.getPlayers();
        for (int i = 0; i < team.getPlayerCount(); i++) {
            sb.append(playerArray[i]);
            if (team.getPlayerCount() != i + 1) {
                sb.append(",");
            } else {
                sb.append(System.lineSeparator() + System.lineSeparator());
            }
        }
        return sb.toString();
    } // end createTeamList
}
