import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessData {

	public ArrayList<Integer> parseCSV(BufferedReader fp) {

		String line;
		ArrayList<Integer>numbers = new ArrayList<Integer>();
		
		try {

			if ((line = fp.readLine()) != null) {

				String[] x = line.split(",");

				for (int i = 0; i < x.length; i++) {

					try {

						numbers.add(Integer.parseInt(x[i].trim()));

					} catch (NumberFormatException nfe) {
						//nfe.printStackTrace();
						System.out.println("Error: " + nfe.getMessage());

					}
				}
				
				return numbers;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return numbers;
	}

}
