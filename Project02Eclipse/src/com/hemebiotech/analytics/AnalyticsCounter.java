package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int dialatedPupilsCount = 0;		
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
				
		// Creation of a FileReader ton read the file
		FileReader fileReader = new FileReader("C:\\Users\\Theotime\\Documents\\OPENCLASSROOMS\\Git\\lebreton-theotime-debug-Java\\Project02Eclipse\\symptoms.txt");

		// Creation of a buffreader who use filereader
		BufferedReader reader = new BufferedReader (fileReader);
			String line = reader.readLine();

			

		while (line != null) {
		
			
			System.out.println("symptom from file: " + line);
			
			if (line.equals("headache")) {
				headacheCount++; // modification from headCount to headacheCount 
				System.out.println("number of headaches: " + headacheCount);
			}
			//correction "rush" in "rash"

			else if (line.equals("rash")) { 
				rashCount++;
				System.out.println("number of rash: " + rashCount); //adding this line for rash count
			}
			else if (line.equals("dialated pupils")) { //correcting dialated pupils and equals instead of contain
				dialatedPupilsCount++;
				System.out.println("number of dialated pupils: " + dialatedPupilsCount); 
			}

			line = reader.readLine();	// get another symptom 	----	Is it usefull ??
			
		}
		reader.close(); // closing the reading of bufferedReader

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilsCount + "\n");
		writer.close();
		
}
}
