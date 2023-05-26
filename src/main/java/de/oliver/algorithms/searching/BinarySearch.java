package de.oliver.algorithms.searching;

import de.oliver.algorithms.SearchAlgorithm;

import java.util.List;


public class BinarySearch implements SearchAlgorithm<List<Integer>, Integer, Integer> {

    /**
     * @param input must be sorted
     * @return the index of searched element, -1 if not found
     */
    @Override
    public Integer search(Integer searched, List<Integer> input) {
        int left = 0;
        int right = input.size();

        while(left <= right){
            int middle = (left + right) / 2;
            if(searched < input.get(middle)){
                right = middle - 1;
            } else if(searched > input.get(middle)){
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
