package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static String outDir = "src/com/company/out/";

    public static List<Integer> readFileAsInts(File file) {
        BufferedReader reader = null;
        FileInputStream inputStream = null;
        List<Integer> fileContents = new ArrayList<>();
        try {
            inputStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                Integer nextInt = Integer.valueOf(line);
                fileContents.add(nextInt);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Clever error handling");
            e.printStackTrace();
        }
        return fileContents;
    }

    public static void writeIntsToFile(List<Integer> list, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outDir.concat(fileName)));
        for (Integer integer: list) {
            writer.write(integer.toString().concat("\n"));
        }
        writer.close();
    }

    public static void writePerformanceToCSV(PerformanceResults results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outDir.concat("performanceResults.csv")));
        writer.write("Algorithm Name, Compute Time, Data Set ID\n");

        String rowF = "%s, %d, %s\n";

        for (PerformanceResults.PerformanceResult performanceResult: results.getResultList()) {
            writer.write(String.format(rowF, performanceResult.getAlgorithmName().getName(), performanceResult.getComputeTime(), performanceResult.getDataSetName()));
        }
        writer.close();
    }

}
