package utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ExcelUtil {
	
	public static Object[][] getRegData(String filepath) throws IOException, CsvException{
		CSVReader reader=new CSVReader(new FileReader(filepath));
		
		List<String[]> allRows = reader.readAll();
		reader.close();
		
		int rows = allRows.size() - 1; 
        int cols = allRows.get(0).length;
		
		Object[][] data=new Object[rows][cols];
		
		for(int i=0;i<rows;i++) {
			String[] rowData = allRows.get(i + 1); 
			for(int j=0;j<cols;j++) {
				data[i][j] = rowData[j];
			}
		}
		return data;
	}
	
}
