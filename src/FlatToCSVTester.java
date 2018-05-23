import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FlatToCSVTester {

	public static void main(String[] args) {
		// Take input from local file
		File inFile = null, outFile = null;
		String input = null;
		
		inFile = new File("flatfile.txt");
		try (Scanner in = new Scanner(inFile);) {
			if(in.hasNext())
				input = in.nextLine();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		// Process data
		Data data = new Data(input);
		
		String outputHeader = "CONNECT ID" + ',' + "PRODUCT CODE" + ',' + "APPLICATION ID" + "APPLICATION LOGON ID" + 
				',' +  "CHANGED TYPE" + ',' + "CHANGED BY USER ID" + ',' + "CHANGED TIMESTAMP" + ',' + "APPLICATION ID ACTIVATION DATE";
				
		String output = data.getConnectId() + ',' + data.getProductCode() + ',' + data.getApplicationId() +
				',' + data.getApplicationLogonId() + ',' + data.getChangedType() + ',' + data.getChangedByUserId() +
				',' + data.getTimestamp() + ',' + data.getApplicationIdActDate(); 
		
		// Output data
		outFile = new File("out.csv");
		OutputStreamWriter writer = null;
		try (FileOutputStream out = new FileOutputStream(outFile);) {			
			writer = new OutputStreamWriter(out);
			writer.write(outputHeader);
			writer.write("\r\n");
			writer.write(output);
			writer.flush();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		
	}
}
