package com.company.algorithms;

import com.company.AlgorithmName;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    public MergeSort() {
        super(AlgorithmName.mergeSort);
    }

    public MergeSort(List<T> collection) {
        super(AlgorithmName.mergeSort, collection);
    }

    @Override
    public void doSort(List<T> dataList) {
        this.mergeSort(dataList, 0, dataList.size() - 1);
    }

    private void mergeSort(List<T> dataList, final int l, final int r) {
        if (l < r) {
            int middle =  (l + r) / 2;
            mergeSort(dataList, l, middle);
            mergeSort(dataList, middle + 1, r);
            merge(dataList, l, middle, r);
        }
    }

    private void merge(List<T> subArray, final int leftStart, final int middle, final int rightEnd) {
        final int leftSize = middle - leftStart + 1;
        final int rightSize = rightEnd - middle;

        List<T> left = new ArrayList<T>();
        List<T> right = new ArrayList<T>();
        for (int i = 0; i < leftSize; i++) {
            left.add(subArray.get(leftStart + i));
        }
        for (int i = 0; i < rightSize; i++) {
            right.add(subArray.get(middle + i + 1));
        }

        int l = 0;
        int r = 0;
        int k = leftStart;

        while (l < leftSize && r < rightSize) {
            T leftElement = left.get(l);
            T rightElement= right.get(r);

            if (leftElement.compareTo(rightElement) <= 0) {
                subArray.set(k, leftElement);
                l++;
            } else {
                subArray.set(k, rightElement);
                r++;
            }
            k++;
        }

        while (l < leftSize) {
            T leftElement = left.get(l);
            subArray.set(k, leftElement);
            l++;
            k++;
        }

        while (r < rightSize) {
            T rightElement= right.get(r);
            subArray.set(k, rightElement);
            r++;
            k++;
        }

    }
}
