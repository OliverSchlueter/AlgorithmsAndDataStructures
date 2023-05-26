package de.oliver.dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>(new Integer[]{1, 2 ,3, 4, 5});
    }

    @Test
    void pop() {
        int n = stack.pop();
        assert n == 1;
    }

    @Test
    void offer() {
        stack.offer(42);
        assert stack.getFirst().getData() == 42;
    }
}