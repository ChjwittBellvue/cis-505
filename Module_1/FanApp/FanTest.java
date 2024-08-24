/*
 * Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_1.FanApp;

public class FanTest {

    // Runs the program.
    public static void main(String[] args) {
        Fan defaultFan = new Fan();
        Fan argumentFan = new Fan(Fan.MEDIUM, true, 3, "Blue");
        System.out.println(defaultFan.toString());
        System.out.println(argumentFan.toString());
    } // end main

}
