package com.hemebiotech.analytics;

import java.util.Map;

public class Main {

    /*
     * This program run an analysis of a file with symptoms,
     * put the entries on a map, count the occurences
     * sort them by alphabetical order and write them
     * on a file line by line.
     */

    public static void main(String[] args) {

        // filepath for the reading of the symptoms
        ISymptomReader reader = new ReadSymptomDataFromFile(
                "C:\\DEV\\Repo\\lebreton-theotime-debug-Java\\Project02Eclipse\\symptoms.txt");

        // filepath for writing the results
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // setting up order of the actions, read first and write second
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        // count the occurences of the symptoms
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms();

        // sort the symptoms with their occurences by alphabetical order
        Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);

        // printing symptoms and their occurences
        System.out.println("Occurrences des symptômes :");
        for (Map.Entry<String, Integer> entry : countSymptoms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

        // printing symptoms and their occurences byt alphabetical order
        System.out.println("Symptômes triés par ordre alphabétique :");
        for (Map.Entry<String, Integer> entry : sortSymptoms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

        // writing the results on the file defined
        analyticsCounter.writeSymptoms(sortSymptoms);

    }
}