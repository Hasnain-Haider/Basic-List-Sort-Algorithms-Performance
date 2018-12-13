package com.company.algorithms;

import com.company.AlgorithmName;

import java.util.List;

public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    public QuickSort() {
        super(AlgorithmName.quickSort);
    }

    public QuickSort(List<T> collection) {
        super(AlgorithmName.quickSort, collection);
    }

    @Override
    public void doSort(List<T> dataList) {
        this.quickSort(dataList, 0, dataList.size() - 1);
    }

    private void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int p = this.partition(list, low, high);
            this.quickSort(list, low, p - 1);
            this.quickSort(list, p + 1, high);
        }
    }

    private int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (list.get(j).compareTo(pivot) <= 0) {
                ++i;
                this.swap(list, i, j);
            }
        }
        this.swap(list, i + 1, high);
        return i + 1;
    }

}
