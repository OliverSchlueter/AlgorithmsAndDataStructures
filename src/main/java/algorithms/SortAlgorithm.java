package algorithms;

import dataStructures.List;

public interface SortAlgorithm<T> {
    boolean isInPlace();
    List<T> sort(List<T> input);
}
