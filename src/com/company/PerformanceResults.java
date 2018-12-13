package com.company;

import com.company.algorithms.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class PerformanceResults {
    List<PerformanceResult> resultList = new ArrayList<PerformanceResult>();

    public void addResult(SortingAlgorithm algorithm, String dataSetName) throws RuntimeException {
        if (algorithm.getSortTime() < 0) {
            throw new RuntimeException("Sort time is < 0, this algorithm may not have run yet");
        }

        this.resultList.add(new PerformanceResult(algorithm, dataSetName));
    }

    public List<PerformanceResult> getResultList() {
        return resultList;
    }

    public static class PerformanceResult {

        protected AlgorithmName algorithmName;
        protected Long computeTime;
        String dataSetName;


        public PerformanceResult(SortingAlgorithm algorithm, String dataSetName) {
            this.algorithmName = algorithm.getName();
            this.computeTime = algorithm.getSortTime();
            this.dataSetName = dataSetName;
        }

        public PerformanceResult(AlgorithmName algorithmName, Long computeTime, String dataSetName) {
            this.algorithmName = algorithmName;
            this.computeTime = computeTime;
            this.dataSetName = dataSetName;
        }

        public AlgorithmName getAlgorithmName() {
            return algorithmName;
        }

        public void setAlgorithmName(AlgorithmName algorithmName) {
            this.algorithmName = algorithmName;
        }

        public Long getComputeTime() {
            return computeTime;
        }

        public void setComputeTime(Long computeTime) {
            this.computeTime = computeTime;
        }

        public String getDataSetName() {
            return dataSetName;
        }
    }
}
