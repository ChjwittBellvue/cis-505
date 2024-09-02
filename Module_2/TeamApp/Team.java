/*
 *  REFERENCES
 * 
 *  Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 *  Modified by Witt, C. 2024
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_2.TeamApp;

// Class definition for Team
public class Team {
    // Attributes
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    /**
     * Constructor for Team
     * 
     * @param String teamName
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }

    // Methods
    /**
     * Adds a player too the array
     * 
     * @param String playerName
     */
    public void addPlayer(String playerName) {
        players[playerCount] = playerName;
        playerCount++;
    } // end addPlayer

    // Getters
    /**
     * Returns player array
     * 
     * @return String[] players
     */
    public String[] getPlayers() {
        return players;
    } // end getPlayers

    /**
     * Returns player count
     * 
     * @return int playerCount
     */
    public int getPlayerCount() {
        return playerCount;
    } // end getPlayerCount

    /**
     * Returns team name
     * 
     * @return String teamName
     */
    public String getTeamName() {
        return teamName;
    } // end getTeamName

}
