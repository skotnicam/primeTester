package org.primeTest;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int numberOfSheet = 0; //Number of sheet - we assume that the input is in the first sheet
    private static final int numberOfColumn = 1; //Number of row - we assume that the input is in the second row

    public static void main(String[] args) {
        try (var argsValidator = new ArgsValidator(args)) //argsValidator owns the stream, and it is responsible for closing it
        {
            var cellsInRow = new CellIsFromStreamIterable(argsValidator.getStream(),numberOfSheet,numberOfColumn);
            for (Cell cell  : cellsInRow) {
                //if the number in the cell is not natural, then it returns -1 which is not a prime
                long number = CommonMethods.toNatural(cell);
                if (CommonMethods.isPrime(number)) {
                    LOGGER.info(String.valueOf(number));
                }
            }
        }
        catch (IOException | ProgramException e) {
            LOGGER.severe("Error reading the Excel file: " + e.getMessage());
        }
        catch (Exception e) {
            LOGGER.severe("Unspecified error: " + e.getMessage());
        }
    }
}