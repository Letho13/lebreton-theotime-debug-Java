package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	// Constructor defining the parameters to class attributes
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	// Getting list of symptoms from ISymptomReader
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	// Counting the symptoms occurences with data called from ISymptoReader
	public Map<String, Integer> countSymptoms() {
		Map<String, Integer> countSymptoms = new HashMap<>();
		List<String> symptoms = reader.getSymptoms();

		for (String symptom : symptoms) {
			countSymptoms.put(symptom, countSymptoms.getOrDefault(symptom, 0) + 1);

		}
		return countSymptoms;

	}

	// Alphabetical order sorting of the symptoms from the file
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> sortSymptoms = new TreeMap<String, Integer>(symptoms);

		return sortSymptoms;
	}
	// Write the result on the files

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
