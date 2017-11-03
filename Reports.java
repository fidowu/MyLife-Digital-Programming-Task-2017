
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Reports {
	
	static int totalIntegers=0;
	static int highestIntegerValue=0;
	static double average=0;
	
	private static int sumTotal=0;
	private static int total=0;
	public static  HashMap<Integer, Integer> commonInteger = new HashMap<Integer,Integer>();
	
	public static void totalIntegersFunc (List<Integer> numbers){
		
		totalIntegers += numbers.size();
	}
	
	public  static void highestInteger(List<Integer> numbers){
		
		Collections.sort(numbers);
		
		if (numbers.size() > highestIntegerValue ) highestIntegerValue = numbers.size();
		
	}
	
	public static void meanValue(List<Integer> numbers){
		
		int sumL = 0, counter = 0;
		for(Integer item: numbers){
			 sumL += item;
			 counter++;	 
	    }

		sumTotal += sumL;
		total += counter;
		average  = (double)sumTotal/ total;
	    
	}
	
	
	public static void commonIntegerList(List<Integer> numbers){
		
		for(Integer item : numbers){
			if (commonInteger.get(item) == null) {
			
				commonInteger.put(item, 1);
					
			} else {
				
				commonInteger.put(item, commonInteger.get(item) +1);
			}
		}
		
	}
	
	public static void commonInteger(){
		
		
	   
	    
	}
}

