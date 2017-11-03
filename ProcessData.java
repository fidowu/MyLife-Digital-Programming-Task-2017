import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessData {
	
	public static void parseCSV(String inputFile) {
		
	   BufferedReader fp;
	   String line;

	        try {
	       
	    		fp = new BufferedReader(new FileReader(inputFile));

				while ((line = fp.readLine()) !=null) {
					
					ArrayList<Integer>numbers = new ArrayList<Integer>();
					String[] x = line.split(",");

					for (int i=0;i<x.length;i++) {

						try {
							
							numbers.add(Integer.parseInt(x[i].trim()));

						} catch (NumberFormatException nfe){
							
							System.out.println("Error: " + nfe.getMessage());

						}
					}
					
					Reports.totalIntegersFunc(numbers);
					Reports.highestInteger(numbers);
					Reports.meanValue(numbers);
					Reports.commonIntegerList(numbers);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			System.out.println("Total Integers: " + Reports.totalIntegers);
			System.out.println("Highest Integer"  + Reports.highestIntegerValue);
			System.out.println("Average:" + String.format("%.3f", Reports.average));
	        System.out.println(Reports.commonInteger.toString());
	}

}
