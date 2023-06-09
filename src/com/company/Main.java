package com.company;

import com.company.algorithms.HeapSort;
import com.company.algorithms.MergeSort;
import com.company.algorithms.QuickSort;
import com.company.algorithms.SortingAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String dataDir = "src/com/company/testData";
        List<File> dataFiles = Arrays.asList(
                new File(dataDir.concat("/set1.txt")),
                new File(dataDir.concat("/set2.txt")),
                new File(dataDir.concat("/set3.txt"))
        );
        List<SortingAlgorithm<Integer>> algorithms = getAlgorithims();
        PerformanceResults performanceResults = new PerformanceResults();

        for (File dataFile : dataFiles) {
            List<Integer> dataSet = Utils.readFileAsInts(dataFile);
            for (SortingAlgorithm<Integer> sortingAlgorithm : algorithms) {
                sortingAlgorithm.setDataSet(dataSet);
                List<Integer> sorted = sortingAlgorithm.sort();
                performanceResults.addResult(sortingAlgorithm, dataFile.getName());
            }
        }

        try {
//            Utils.writePerformanceToCSV(performanceResults);
            Utils.toStdOut(performanceResults);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<SortingAlgorithm<Integer>> getAlgorithims() {
        List<SortingAlgorithm<Integer>> algorithms = new ArrayList<SortingAlgorithm<Integer>>();
        algorithms.add(new MergeSort<Integer>());
        algorithms.add(new QuickSort<Integer>());
        algorithms.add(new HeapSort<Integer>());
        return algorithms;
    }

}
