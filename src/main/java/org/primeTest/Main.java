package org.primeTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.logging.Logger;
import static java.lang.Character.isDigit;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final int numberOfSheet = 0; //Number of sheet - we assume that the input is in the first sheet
    private static final int numberOfColumn = 1; //Number of row - we assume that the input is in the second row

    public static void main(String[] args) {
        try (var argsValidator = new ArgsValidator(args)){
            Workbook workbook = new XSSFWorkbook(argsValidator.getStream());
            Sheet sheet = workbook.getSheetAt(numberOfSheet);
            for (Row row : sheet) {
                long number = CommonMethods.toNatural(row.getCell(numberOfColumn));
                if (CommonMethods.isPrime(number))
                    LOGGER.info(String.valueOf(number));
            }
        }
        catch (IOException | ProgramException e) {
            LOGGER.severe("Error reading the Excel file: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}