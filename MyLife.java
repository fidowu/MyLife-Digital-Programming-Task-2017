import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MyLife {
	
	private static HashMap<Integer, Integer> hm; //holds key value pairs for data within CSV file. Key is the integer 
												//and value holds the frequency that integer appears.
	private static int highestNumber = 0;		//Initialisation count for line with most integers

	/*
	 * Within the parsed CSV return the total 
	 * number of valid integers.
	 */
	private static int totalIntegers(){
		int counter = 0;
		for(Integer item : hm.keySet()){
	           counter += hm.get(item);
	     }
		return counter;
	}
	
	/*
	 * Within the parsed CSV return the average for all 
	 * valid integers.
	 */
	private static String meanValue(){
		
		int total = 0, sum = 0; 
		for(Integer item: hm.keySet()){
			 sum += (item * hm.get(item));
			 
	         total += hm.get(item);
	     }
		
	    return String.format("%.3f", (double)sum/ (double)total);
	}
	
	/*
	 * Within the parsed CSV find the integer(s) that
	 * has the highest frequency. 
	 */
	private static String commonInteger() {
		
		String common ="";
		int frequency = 0;
				
		for(Integer item : hm.keySet()){
			if (hm.get(item) > frequency) { 
				frequency = hm.get(item);
				common = "";
			} 
			if (hm.get(item) == frequency) { 
				common += " " + item;
			}
	     }
		
		return common;
	}
	
	/*
	 * Within the parsed CSV return the count for 
	 * the line with the most integers.
	 */
	private static int highestInteger(){
		
		return highestNumber;
	}
		
	/*
	 * Helper, does the integer key exist in HashMap?
	 * If it does then increment it's frequency counter. 
	 */
	private static boolean keyExists(Integer key) {
		
		if (hm.get(key) != null) {
			
			hm.put(key, hm.get(key) + 1); //increase counter
			
			return true;
		}
		return false;
		
	}
	
	/*
	 * Helper - validate fields within CSV file, ensure passed 
	 * number is an integer.
	 */
	private static boolean isInteger (String number){
		
		try {
			
			@SuppressWarnings("unused")
			int result = Integer.parseInt(number);
			
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * Parse passed CSV and store values in a HashMap - key being the integer and value 
	 * the frequency that integer appears in file.
	 * 
	 */
	private static void parseCSV(String fileInput){
		
	    BufferedReader fp = null;
	    String line = "", delimiter = ",", file = fileInput;
	    int li = 0;
	    
	    hm = new HashMap<Integer,Integer>(); 
	    	     
	    try {
	    	
         fp = new BufferedReader(new FileReader(file));
         
         while ((line = fp.readLine()) != null) {
        	 
        	 int currHighest = 0; //no of integers on line
        	 li++;
        	 
             String[] numbers = line.split(delimiter);
             
             for (String key : numbers){
            	             	 
            	 key = key.replaceAll("\\s+","");
            	 if (isInteger(key)) {
            		 
            		 int k = Integer.parseInt(key);
            		 if (!keyExists(k)) hm.put(k,1); 
            		 
                	 currHighest++; //record the number of integers on this line

            	 } else {
            		 
            		 System.out.println("Error: Number " + key + " on line " + li + 
            				 " is not an integer - so has been excluded from any calculations!");
            	 }
             }
             
             //swap highest line count if current line has more
             if (currHighest > highestNumber) highestNumber = currHighest;
             
         }
         
	    } catch (FileNotFoundException e) {
	    	
	    	 System.out.println("Error: unable to locate file " + file);
	    	 
	    } catch (IOException ex) {
	    	
	    	System.out.println( ex.getMessage());
	    	
	    } finally {
       
	    	try {
				fp.close();
			} catch (IOException e) {
				
		    	System.out.println( e.getMessage());
			}
	    }
	}
	
	/*
	 * Generate reports as per requirements.
	 */
	public static void reports(String file){
		
		parseCSV(file);
		
		System.out.println("Total number of integers: " + totalIntegers());
		System.out.println("Most common integer(s):" + commonInteger());
		System.out.println("Mean value of all integers: " + meanValue());
		System.out.println("Highest number of integers in a single line: " + highestInteger());
				
	}
}