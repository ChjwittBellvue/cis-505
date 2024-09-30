/*
 *  REFERENCES
 * 
 *  Witt, C. (2024). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 */
package Module_8.EnhancedFutureValueApp;

public class FinanceCalculator {
    // Constants
    private static int MONTHS_IN_YEAR = 12;

    /**
     * Calculates future value based on UI input
     * 
     * @param monthlyPayment
     * @param rate
     * @param years
     * @return double - future value
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = MONTHS_IN_YEAR * years;
        double interestRate = (1 + rate / 100);
        double presentValue = monthlyPayment * months;
        double futureValue = presentValue * (Math.pow(interestRate, months));

        return futureValue;
    }
}
