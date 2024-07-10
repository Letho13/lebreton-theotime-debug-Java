package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data on the files result.out
 * it is a map of
 * strings and value,
 * it is sorted by alphabetical order
 * 
 * 
 * The implementation need to write the list
 * 
 */

public interface ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms);

}
