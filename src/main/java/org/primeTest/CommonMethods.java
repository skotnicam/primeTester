package org.primeTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import static java.lang.Character.isDigit;

public class CommonMethods {
    private static final DataFormatter formatter = new DataFormatter();

    /**
     * Check if there is a natural number in a given cell and eventually returns its value.
     * @param  cell a cell from an excel sheet
     * @param  name the location of the image, relative to the url argument
     * @return      value of the natural number in the cell or -1 if the content of the cell is not a natural number
     */
    public static long toNatural(Cell cell) {

        if (cell == null)
            return -1;
        long x = 0;
        char[] charArray = formatter.formatCellValue(cell).toCharArray();
        for (char c : charArray) {
            if(' ' == c)
                continue;
            if(isDigit(c))
                x = x*10 + Character.getNumericValue(c);
            else return -1;
        }
        return 0 == x ? -1 : x;
    }

    public static boolean isPrime(long n)
    {
        //https://www.geeksforgeeks.org/java-prime-number-program/ used
        // Corner case
        if (n <= 1)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i < Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}
