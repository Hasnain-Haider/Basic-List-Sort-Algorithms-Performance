package com.company.algorithms;

import com.company.AlgorithmName;

import java.util.List;

public class HeapSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
    public HeapSort() {
        super(AlgorithmName.heapSort);
    }

    @Override
    protected void doSort(List list) {
        int size = list.size();
        for (int i = size/2 -1 ; i>= 0; i--) {
            this.heapify(list, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            this.swap(list, 0, i);
            this.heapify(list, i, 0);
        }
    }

    private void heapify(List<T> list, int size, int i) {

        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < size && list.get(l).compareTo(list.get(largest)) > 0){
            largest = l;
        }

        if (r < size && list.get(r).compareTo(list.get(largest)) > 0) {
            largest = r;
        }

        if (largest != i) {
            this.swap(list, i, largest);
            this.heapify(list, size, largest);
        }
    }

}
