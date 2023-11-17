package org.primeTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommonMethodsTest {

    @org.junit.jupiter.api.Test
    void isPrime() {
        assertTrue(CommonMethods.isPrime(2));
        assertTrue(CommonMethods.isPrime(997));

        assertFalse(CommonMethods.isPrime(1));
        assertFalse(CommonMethods.isPrime(4343782));
    }

    @org.junit.jupiter.api.Test
    void toNatural() {
        try(Workbook workbook = new XSSFWorkbook()) {
            //create a fake sheet
            Sheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);
            //check natural numbers
            //numeric
            Cell cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(123);
            assertEquals(123,CommonMethods.toNatural(cell));
            //string
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("24");
            assertEquals(24,CommonMethods.toNatural(cell));
            //Check non-natural numbers
            row.createCell(2, CellType.STRING).setCellValue("this is not a number");
            sheet.createRow(1).createCell(2, CellType.BOOLEAN).setCellValue(true);
            sheet.createRow(2).createCell(2, CellType.NUMERIC).setCellValue(-18);
            //etc. Now test it using CellFromExcel
            var cellsInRow = new CellIsFromExcelIterable(workbook, 0,2);
            for(Cell c : cellsInRow){
                assertEquals(-1,CommonMethods.toNatural(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}