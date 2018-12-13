package com.company;

public enum AlgorithmName {
    mergeSort("mergeSort"),
    quickSort("quickSort"),
    heapSort("heapSort");

    AlgorithmName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    String name;
}
