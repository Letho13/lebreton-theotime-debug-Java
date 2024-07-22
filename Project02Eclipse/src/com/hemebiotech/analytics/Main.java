package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    static String filePathReader = "C:\\DEV\\Repo\\lebreton-theotime-debug-Java\\Project02Eclipse\\symptoms.txt";
    static String filePathWriter = "result.out";

    /*
     * This program run an analysis of a file with symptoms,
     * put the entries on a map, count the occurences
     * sort them by alphabetical order and write them
     * on a file line by line.
     */

    public static void main(String[] args) {

                
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile(filePathReader), new WriteSymptomDataToFile(filePathWriter));

        List<String> symptoms = analyticsCounter.getSymptoms();
        
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
        
        Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
              
        analyticsCounter.writeSymptoms(sortSymptoms);

    }
}