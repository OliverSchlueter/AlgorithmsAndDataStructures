package algorithms.sorting;

import algorithms.Algorithm;
import algorithms.SortAlgorithm;
import dataStructures.List;

public class BubbleSort extends Algorithm implements SortAlgorithm<Integer> {

    public BubbleSort() {
        super("BubbleSort", "O(n^2)");
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    @Override
    public List<Integer> sort(List<Integer> input) {
        for (int i = 0; i < input.getSize(); i++) {
            for (int j = 0; j < input.getSize()-1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

        return input;
    }
}
