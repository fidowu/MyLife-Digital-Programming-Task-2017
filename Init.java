import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Init {

	public static void init(String fileInput){
		
		ArrayList<Integer>numbers = new ArrayList<Integer>();

		try {
			
			BufferedReader fp = new BufferedReader(new FileReader(fileInput));

			ProcessData pd = new ProcessData();
			
			try {
					do {
						numbers = pd.parseCSV(fp);
					
						Reports.totalIntegersFunc(numbers);
						Reports.highestInteger(numbers);
						Reports.meanValue(numbers);
						Reports.commonIntegerList(numbers);
					
					} while (numbers.size() >0 );
					
					
			} finally {
				try {
					fp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
						
			System.out.println("Total Integers: " + Reports.totalIntegers);
			System.out.println("Highest Integer:" + Reports.highestIntegerValue);
			System.out.println("Average:" + String.format("%.3f", Reports.average));
			System.out.println(Reports.commonInteger.toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
