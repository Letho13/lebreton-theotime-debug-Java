package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedPupilsCount = 0;

	// Setp 4.1 creating constructor with object

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	// Setp 4.2 Getting list of symptoms from the file
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	// Setp 4.3 counting the symptoms from the file

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		symptoms.size();
		return countSymptoms(symptoms);
				}

	// Setp 4.4 alphabetical order sorting of the symptoms from the file

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		
		Map<String, Integer> sortSymptoms = new TreeMap <String, Integer>(symptoms);
		
		return sortSymptoms(sortSymptoms);
	 }
	 // Setp 4.5 Creating method to write the result on the files 
	 
	 public void writeSymptoms(Map<String, Integer> symptoms) {
			writer.writeSymptoms(symptoms);	
			 }

	public static void main(String args[]) throws Exception {

		// Creation of a FileReader ton read the file
		FileReader fileReader = new FileReader(
				"C:\\DEV\\Repo\\lebreton-theotime-debug-Java\\Project02Eclipse\\symptoms.txt");

		// Creation of a buffreader who use filereader
		BufferedReader reader = new BufferedReader(fileReader);
		String line = reader.readLine();

		while (line != null) {

			System.out.println("symptom from file: " + line);

			if (line.equals("headache")) {
				headacheCount++; // modification from headCount to headacheCount
				System.out.println("number of headaches: " + headacheCount);
			}
			// correction "rush" in "rash"

			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rash: " + rashCount); // adding this line for rash count
			} else if (line.equals("dialated pupils")) { // correcting dialated pupils and equals instead of contain
				dialatedPupilsCount++;
				System.out.println("number of dialated pupils: " + dialatedPupilsCount);
			}

			line = reader.readLine(); // get another symptom ---- Is it usefull ??

		}
		reader.close(); // closing the reading of bufferedReader

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilsCount + "\n");
		writer.close();

	}
}
