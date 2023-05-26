package de.oliver.algorithms.sorting;

import de.oliver.dataStructures.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

class BogoSortTest {

    final Random random = new Random();
    final BogoSort bogoSort = new BogoSort();

    List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new de.oliver.dataStructures.List<>();
        for (int i = 0; i < 10; i++) {
            input.pushEnd(random.nextInt(-100, 100));
        }
    }

    // Reduced amount to 5, because it takes forever
    @RepeatedTest(5)
    void sort() {
        bogoSort.sort(input);
        for (int i = 0; i < input.getSize() - 1; i++) {
            assert input.get(i) <= input.get(i + 1);
        }
    }
}