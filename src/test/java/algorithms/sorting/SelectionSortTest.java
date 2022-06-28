package algorithms.sorting;

import dataStructures.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    final Random random = new Random();
    final SelectionSort selectionSort = new SelectionSort();

    List<Integer> input;

    @BeforeEach
    void setUp(){
        input = new List<>();
        for (int i = 0; i < 1000; i++) {
            input.pushEnd(random.nextInt(-100, 100));
        }
    }

    @Test
    void sort() {
        selectionSort.sort(input);
        for (int i = 0; i < input.getSize() - 1; i++) {
            assert input.get(i) <= input.get(i + 1);
        }
    }
}