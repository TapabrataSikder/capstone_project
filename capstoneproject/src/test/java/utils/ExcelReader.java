package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {
    public static Object[][] getExcelData(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);
        
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j);
                	data[i][j] = (cell == null) ? "" : cell.toString();
            }
        }
        wb.close();
        return data;
    }
}