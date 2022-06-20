package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {

    List<Integer> list;

    @BeforeEach
    void setUp(){
        list = new List<>();
        list.pushEnd(1);
        list.pushEnd(2);
        list.pushEnd(3);
        list.pushEnd(4);
        list.pushEnd(5);
    }

    @Test
    void pushEnd() {
        list.pushEnd(6);
        assert list.get(5) == 6;
    }

    @Test
    void pushStart() {
        list.pushStart(0);
        assert list.get(0) == 0;
    }

    @Test
    void removeAtIndex() {
        list.removeAtIndex(2);
        assert list.getSize() == 4;
        assert list.get(2) == 4;
    }

    @Test
    void remove() {
        list.remove(3);
        assert list.getSize() == 4;
        assert list.get(2) == 4;
    }

    @Test
    void clear() {
        list.clear();
        assert list.getSize() == 0;
    }

    @Test
    void set() {
        list.set(1, 42);
        assert list.get(1) == 42;
    }

    @Test
    void get() {
        assert list.get(3) == list.getDataArray().get(3);
    }

    @Test
    void indexOf() {
        assert list.indexOf(5) == 4;
    }

    @Test
    void contains() {
        assert list.contains(4);
        assert !list.contains(1337);
    }

    @Test
    void testToString() {
        assert list.toString().equals("[1, 2, 3, 4, 5]");
    }

    @Test
    void getSize() {
        list.pushEnd(42);
        assert list.getSize() == 6;
    }
}