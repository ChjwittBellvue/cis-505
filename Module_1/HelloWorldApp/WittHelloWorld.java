/*
 *  REFERENCES
 * 
 *  Payne, D. (2021). CSD 405 Intermediate Java Programming. Bellevue University. Modified by Witt, C. 2024
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */

package Module_1.HelloWorldApp;

public class WittHelloWorld {
  // Constants
  final static String FIRST_NAME = "Christopher";
  final static String LAST_NAME = "Witt";

  // Runs the program.
  public static void main(String[] args) {
    System.out.printf(helloWorldStringBuilder());
  } // end main

  /*
   * Builds hello world String from class constants.
   */
  private static String helloWorldStringBuilder() {
    return "Hello World from " + FIRST_NAME + " " + LAST_NAME + ".";
  } // end helloWorldStringBuilder
}