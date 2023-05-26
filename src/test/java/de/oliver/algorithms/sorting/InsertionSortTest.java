package de.oliver.algorithms.sorting;

import de.oliver.dataStructures.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;


class InsertionSortTest {

    final Random random = new Random();
    final InsertionSort insertionSort = new InsertionSort();

    List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new List<>();
        for (int i = 0; i < 1000; i++) {
            input.pushEnd(random.nextInt(-100, 100));
        }
    }

    @RepeatedTest(100)
    void sort() {
        List<Integer> sorted = insertionSort.sort(input);
        for (int i = 0; i < sorted.getSize() - 1; i++) {
            assert sorted.get(i) <= sorted.get(i + 1);
        }
    }
}