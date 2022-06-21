package algorithms.searching;

import algorithms.Algorithm;
import algorithms.SearchAlgorithm;
import dataStructures.List;

public class LinearSearch<T> extends Algorithm implements SearchAlgorithm<List<T>, T, Integer> {

    public LinearSearch() {
        super("LinearSearch", "O(n)");
    }

    /**
     * @return the index of the element. -1 if not found
     */
    @Override
    public Integer search(T searched, List<T> input) {
        for (int i = 0; i < input.getSize(); i++) {
            if(input.get(i).equals(searched)){
                return i;
            }
        }

        return -1;
    }
}
