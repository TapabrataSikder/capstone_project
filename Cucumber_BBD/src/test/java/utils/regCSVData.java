package utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class regCSVData {
	public static Object[][] getCSVData(String filepath) throws Exception {
        List<String[]> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        
        // Skip the header row
        br.readLine(); 
        
        String line;
        while ((line = br.readLine()) != null) {
            // Split by comma
            String[] values = line.split(",");
            // Trim whitespace to ensure clean data input
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].trim();
            }
            records.add(values);
        }
        br.close();
        
        // Convert List to Object[][]
        return records.toArray(new Object[0][0]);
    }
}
