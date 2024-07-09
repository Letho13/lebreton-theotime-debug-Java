package com.hemebiotech.analytics;


import java.util.Map;


/**
 * Anything that will write symptom data on the files result.out
 * The important part is, the return value from the operation, which is a map of strings and value,
 * that may contain many duplications
 * 
 * 
 * The implementation need to order the list
 * 
 */

public interface ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms);


}
