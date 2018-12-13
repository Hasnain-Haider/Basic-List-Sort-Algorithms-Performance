package Test;

import com.company.algorithms.SortingAlgorithm;
import com.company.Utils;
import com.company.algorithms.MergeSort;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        final String dataDir = "src/com/company/data";
        final String sortedDirs = "src/Test/results";

        List<String> dataFilePaths = Arrays.asList(dataDir.concat("/set1.txt"));
        List<String> referenceFilePaths = Arrays.asList(sortedDirs.concat("/set1Sorted.txt"));
        List<SortingAlgorithm<Integer>> algorithms = buildAlgoList();

        for (int i = 0; i < dataFilePaths.size(); ++i) {
            String dataFilePath = dataFilePaths.get(i);
            String referenceFilePath = referenceFilePaths.get(i);

            List<Integer> dataSet = Utils.readFileAsInts(new File(dataFilePath));
            List<Integer> referenceList = Utils.readFileAsInts(new File(referenceFilePath));

            for (SortingAlgorithm<Integer> sortingAlgorithm : algorithms) {
                sortingAlgorithm.setDataSet(dataSet);
                List<Integer> sortedAlgData = sortingAlgorithm.sort();
                testListsAreEql(sortedAlgData, referenceList);
            }
        }

    }

    private void testListsAreEql(List<Integer> l, List<Integer> r) {
        for (int j = 0; j < l.size(); j++) {
            Integer fromAlgorithmInt = l.get(j);
            Integer sortedInt = r.get(j);
            boolean bool = sortedInt.equals(fromAlgorithmInt);
            assert (bool);
        }
    }

    private List<SortingAlgorithm<Integer>> buildAlgoList() {
        List<SortingAlgorithm<Integer>> sortingAlgorithms = new ArrayList<>();

        SortingAlgorithm<Integer> ms = new MergeSort<Integer>();
        sortingAlgorithms.add(ms);


        return sortingAlgorithms;
    }
}
