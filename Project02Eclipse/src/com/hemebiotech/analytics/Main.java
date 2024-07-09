package com.hemebiotech.analytics;

import java.util.Map;

public class Main {
    public static void main(String[] args){
    
    ISymptomReader reader = new ReadSymptomDataFromFile ("C:\\DEV\\Repo\\lebreton-theotime-debug-Java\\Project02Eclipse\\symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile ("result.out");
    
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

    Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms();

    Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);



    System.out.println("Occurrences des symptômes :");
        for (Map.Entry<String, Integer> entry : countSymptoms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
    
    }

    System.out.println("Symptômes triés par ordre alphabétique :");
        for (Map.Entry<String, Integer> entry : sortSymptoms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());


}

analyticsCounter.writeSymptoms(sortSymptoms);

}
}