package de.oliver.algorithms.sorting;

import de.oliver.algorithms.Algorithm;
import de.oliver.algorithms.SortAlgorithm;
import de.oliver.dataStructures.List;

import java.util.Random;

/**
 * Maybe the worst sorting algorithm.
 * Meant to be a fun algorithm.
 */
public class BogoSort extends Algorithm implements SortAlgorithm<Integer> {

    private final Random random = new Random();

    public BogoSort() {
        super("BogoSort", "Best case: O(n). Worst case: O(infinity)");
    }

    @Override
    public boolean isInPlace() {
        return true;
    }

    private boolean isSorted(List<Integer> input){
        for (int i = 0; i < input.getSize() - 1; i++) {
            if(input.get(i + 1) < input.get(i)){
                return false;
            }
        }

        return true;
    }

    @Override
    public List<Integer> sort(List<Integer> input) {
        while(!isSorted(input)){
            for (int i = 0; i < input.getSize(); i++) {
                int randomIndex = random.nextInt(0, input.getSize());
                int temp = input.get(i);
                input.set(i, input.get(randomIndex));
                input.set(randomIndex, temp);
            }
        }
        return input;
    }
}
