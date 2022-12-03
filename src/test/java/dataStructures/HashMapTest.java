package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashMapTest {

    HashMap<Integer, Integer> hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMap<>();
        hashMap.put(1, 9);
        hashMap.put(2, 8);
        hashMap.put(3, 7);
        hashMap.put(4, 6);
    }

    @Test
    void put() {
        hashMap.put(5, 5);
        assert hashMap.get(5) == 5;

        hashMap.put(2, 42);
        assert hashMap.get(2) == 42;
    }

    @Test
    void get() {
        assert hashMap.get(2) == 8;
        assert hashMap.get(1) == 9;
    }

    @Test
    void containsKey() {
        assert hashMap.containsKey(3);
        try{
            hashMap.containsKey(42);
            assert false;
        } catch (NullPointerException e){
            assert true;
        }
    }

    @Test
    void getEntries() {
        assert hashMap.getEntries().getSize() == 4;
    }

    @Test
    void getKeys() {
        assert hashMap.getKeys().getSize() == 4;
    }

    @Test
    void getValues() {
        assert hashMap.getValues().getSize() == 4;
    }

    @Test
    void remove() {
        hashMap.remove(1);
        assert hashMap.getEntries().size == 3;
        try{
            hashMap.get(1);
            assert false;
        } catch (NullPointerException e){
            assert true;
        }
    }

    @Test
    void testToString() {
        assert hashMap.toString().equals("[(1: 9), (2: 8), (3: 7), (4: 6)]");
    }
}