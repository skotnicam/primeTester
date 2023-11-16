package org.primeTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.junit.jupiter.api.Assertions.*;

class CommonMethodsTest {

    @org.junit.jupiter.api.Test
    void isPrime() {
        assertTrue(CommonMethods.isPrime(2));
        assertTrue(CommonMethods.isPrime(997));

        assertFalse(CommonMethods.isPrime(1));
        assertFalse(CommonMethods.isPrime(4343782));
    }
}