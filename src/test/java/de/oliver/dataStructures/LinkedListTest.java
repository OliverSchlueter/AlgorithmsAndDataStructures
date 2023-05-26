package de.oliver.dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>(new Integer[] { 1, 2, 3, 4, 5 });
    }

    @Test
    void pushEnd() {
        linkedList.pushEnd(6);
        assert linkedList.get(5) == 6;
    }

    @Test
    void pushStart() {
        linkedList.pushStart(0);
        assert linkedList.get(0) == 0;
    }

    @Test
    void pushAfter() {
        linkedList.pushAfter(42, 2);
        assert linkedList.findElementByData(2).getNext().getData() == 42;
    }

    @Test
    void pushBefore() {
        linkedList.pushBefore(1337, 2);
        assert linkedList.findElementByData(1337).getNext().getData() == 2;
    }

    @Test
    void getElement() {
        LinkedListElement<Integer> element = linkedList.getElement(2);
        assert element.getData() == 3;
    }

    @Test
    void get() {
        assert linkedList.get(3) == 4;
    }

    @Test
    void set() {
        linkedList.set(42, 2);
        assert linkedList.get(2) == 42;
    }

    @Test
    void replace() {
        linkedList.replace(4, 42);
        assert linkedList.getElement(3).getData() == 42;
    }
    
    @Test
    void clear(){
        linkedList.clear();
        assert linkedList.getFirst() == null;
    }

    @Test
    void findElementByData() {
        LinkedListElement<Integer> element = linkedList.findElementByData(1);
        assert element.getData() == 1;
    }

    @Test
    void getPreviousOfElement() {
        LinkedListElement<Integer> element = linkedList.getPreviousOfElement(linkedList.getElement(1));
        assert element == linkedList.getFirst();
    }

    @Test
    void testToString() {
        assert linkedList.toString().equals("[1 -> 2 -> 3 -> 4 -> 5]");
    }

    @Test
    void getFirst() {
        assert linkedList.getFirst().getData() == 1;
    }
}