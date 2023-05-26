package de.oliver.algorithms;

import de.oliver.dataStructures.List;

public interface SortAlgorithm<T> {
    boolean isInPlace();
    List<T> sort(List<T> input);
}
