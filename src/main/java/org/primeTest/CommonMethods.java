package org.primeTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import static java.lang.Character.isDigit;

public class CommonMethods {
    /*
    //constants for probability prime testing
    //if a tester number is greater than "threshold", a probabilistic test with certainty "certainty" is used
    private static final long threshold = TODO;
    private static final int certainty = TODO;
    */

    //data formatter  for formatting Excel cells
    private static final DataFormatter formatter = new DataFormatter();

    /**
     * Checks if there is a natural number in a given cell and eventually returns its value.
     * If we expect large large numbers, long may be substituted by BigInteger.
     * @param  cell a cell from an Excel sheet
     * @return      value of the natural number in the cell or -1 if the content of the cell is not a natural number
     */
    public static long toNatural(Cell cell) {
        if (cell == null) {
            return -1;
        }
        char[] charArray = formatter.formatCellValue(cell).toCharArray();
        long x = 0;
        for (char c : charArray) {
            if(' ' == c) {
                continue;
            }
            if(isDigit(c)) {
                x = x*10 + Character.getNumericValue(c);
            } else {
                return -1;
            }
        }
        return 0 == x ? -1 : x;
    }

    /**
     * Checks if a given number is integer.
     * A trivial method with a small <a href="https://www.geeksforgeeks.org/java-prime-number-program/">heuristic</a>
     * is used. If we expect very large numbers, we can uncomment the commented out code
     * or eventually, replace long with BigInteger.
     * @param  n    number
     * @return number n is prime
     */
    public static boolean isPrime(long n) {
        /*
        if(n > threshold){ //when the number is too big
            return BigInteger.valueOf(n).isProbablePrime(certainty);
        }
        */
        //otherwise use a trivial method with a small heuristic borrowed from
        //https://www.geeksforgeeks.org/java-prime-number-program/
        // Corner case
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i < Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        return true;
    }
}
