package de.oliver.algorithms.sorting;

import de.oliver.algorithms.Algorithm;
import de.oliver.algorithms.SortAlgorithm;
import de.oliver.dataStructures.List;

public class InsertionSort extends Algorithm implements SortAlgorithm<Integer> {

    public InsertionSort() {
        super("InsertionSort", "O(n^2)");
    }

    @Override
    public boolean isInPlace() {
        return false;
    }

    @Override
    public List<Integer> sort(List<Integer> input) {
        List<Integer> output = new List<>();
        output.pushEnd(input.get(0));

        for (int i = 1; i < input.getSize(); i++) {
            int val = input.get(i);

            if(output.getSize() == 1){
                if(val < output.get(0)){
                    output.pushBefore(0, val);
                } else {
                    output.pushAfter(0, val);
                }
                continue;
            }

            if(val <= output.get(0)){
                output.pushStart(val);
                continue;
            }

            if(val >= output.get(output.getSize() - 1)){
                output.pushEnd(val);
                continue;
            }

            for (int j = 1; j < output.getSize(); j++) {
                if(output.get(j - 1) <= val && output.get(j) >= val){
                    output.pushBefore(j, val);
                    break;
                }
            }
        }

        return output;
    }
}
