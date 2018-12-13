package com.company.algorithms;

import com.company.AlgorithmName;

import java.util.ArrayList;
import java.util.List;

public abstract class SortingAlgorithm<T extends Comparable<T>> {
    protected List<T> dataSet = null;

    protected Long sortTime = -1L;

    protected AlgorithmName name;

    protected SortingAlgorithm(AlgorithmName name) {
        this.name = name;
    }

    protected SortingAlgorithm(AlgorithmName name, List<T> list) {
        this.name = name;
        this.dataSet = list;
    }


    public List<T> sort() {
        if (this.dataSet == null) {
            throw new RuntimeException("\"datasource\" is not yet initialized");
        }

        // create a copy of the list
        List<T> dataList = new ArrayList<T>(this.dataSet);

        Long startTime = System.currentTimeMillis();
        this.doSort(dataList);
        this.sortTime = System.currentTimeMillis() - startTime;

        return dataList;
    }

    // Getters, Setters
    public AlgorithmName getName() {
        return name;
    }

    public Long getSortTime() {
        return this.sortTime;
    }

    public List<T> getDataSet() {
        return dataSet;
    }

    public void setDataSet(List<T> dataSet) {
        this.dataSet = dataSet;
    }

    protected void swap(List<T> dataSet, int l, int r) {
        T tmp = dataSet.get(l);
        dataSet.set(l, dataSet.get(r));
        dataSet.set(r, tmp);
    }

    // Encapsulated sorting logic in the following abstract method
    protected abstract void doSort(List<T> dataList);
}
