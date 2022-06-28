package algorithms.sorting;

import algorithms.Algorithm;
import algorithms.SortAlgorithm;
import dataStructures.List;

public class SelectionSort extends Algorithm implements SortAlgorithm<Integer> {

    public SelectionSort() {
        super("SelectionSort", "O(n^2)");
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public List<Integer> sort(List<Integer> input) {
        for (int left = 0; left < input.getSize() - 1; left++) {
            for (int i = left+1; i < input.getSize(); i++) {
                if(input.get(i) <= input.get(left)){
                    int temp = input.get(left);
                    input.set(left, input.get(i));
                    input.set(i, temp);
                }
            }
        }

        return input;
    }
}
