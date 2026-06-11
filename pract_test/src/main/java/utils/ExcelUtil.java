package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
	public static Object[][] getCSVData(String filepath) throws Exception{
		List<Object[]> records = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		
		br.readLine(); // Skip header line
		
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			records.add(values);
		}
		br.close();
		return records.toArray(new Object[0][0]);
		
	}
}
