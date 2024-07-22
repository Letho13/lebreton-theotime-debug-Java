package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymptoms = new HashMap<>();
		
		for (String symptom : symptoms) {
			countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1);
			}	
			
			return countSymptoms;
			
	}

	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> sortSymptoms = new TreeMap<String, Integer>(symptoms);

		return sortSymptoms;
	}

	

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
