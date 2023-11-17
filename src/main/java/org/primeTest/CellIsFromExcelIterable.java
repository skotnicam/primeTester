package org.primeTest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class CellIsFromExcelIterable implements Iterable<Cell> {
    int columnID;
    Workbook workbook;
    Sheet sheet;
    public CellIsFromExcelIterable(FileInputStream stream, int sheetID, int columnID) throws IOException {
        this(new XSSFWorkbook(stream), sheetID, columnID);
    }

    //Constructor for unit testing using workbook instead of stream
    public CellIsFromExcelIterable(Workbook workbook, int sheetID, int columnID) {
        this.workbook = workbook;
        sheet = workbook.getSheetAt(sheetID);
        this.columnID = columnID;
    }
    @Override
    public Iterator<Cell> iterator() {
        return new CellFromRowIterator();
    }
    class CellFromRowIterator implements Iterator<Cell> {
        Iterator<Row> rowIterator;
        public CellFromRowIterator() {
            rowIterator = sheet.iterator();
        }
        @Override
        public boolean hasNext() {
            return rowIterator.hasNext();
        }
        @Override
        public Cell next() {
            return rowIterator.next().getCell(columnID);
        }
    }
}
