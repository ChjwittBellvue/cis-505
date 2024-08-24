/*
 *  REFERENCES
 * 
 *  Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */

package Module_1.HelloWorldApp;

public class WittHelloWorld {

  // Runs the program.
  public static void main(String[] args) {
    System.out.printf(helloWorldStringBuilder("Christopher", "Witt"));
  } // end main

  /*
   * Builds hello world String from class constants.
   * 
   * @param firstName String
   * 
   * @param lastName String
   * 
   * @return returns hello world string with first and last name.
   */
  private static String helloWorldStringBuilder(String firstName, String lastName) {
    return "Hello World from " + firstName + " " + lastName + ".";
  } // end helloWorldStringBuilder
}