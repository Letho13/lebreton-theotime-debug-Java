package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
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

	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> countSymptoms = new HashMap<>();
		List<String> symptoms = reader.getSymptoms();

		for (String symptom : symptoms) {
			countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1);
			
					}	
		return countSymptoms;
		
	}
	
					
	// Setp 4.4 alphabetical order sorting of the symptoms from the file

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		
		Map<String, Integer> sortSymptoms = new TreeMap <String, Integer>(symptoms);
		
		return sortSymptoms;
	 }
	 // Setp 4.5 Creating method to write the result on the files 
	 
	 public void writeSymptoms(Map<String, Integer> symptoms) {
			writer.writeSymptoms(symptoms);	
			 }

			 
		
}

