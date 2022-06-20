package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    Array<Integer> array;

    @BeforeEach
    void setUp() {
        array = new Array<>(5);
        array.set(2, 42);
    }

    @Test
    void get() {
        assert array.get(2) == 42;
    }

    @Test
    void set() {
        array.set(1, 324);
        assert array.get(1) == 324;
    }

    @Test
    void testToString() {
        assert array.toString().equals("[null, null, 42, null, null]");
    }

    @Test
    void getSize() {
        assert array.getSize() == 5;
    }

    @Test
    void free(){
        int startPtr = array.getStartPtr();
        int size = array.getSize();
        array.free();

        for (int i = startPtr; i < size; i++) {
            assert Array.MEMORY[startPtr + i] == null;
        }
    }
}