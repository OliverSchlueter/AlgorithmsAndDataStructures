package dataStructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void setUp(){
        queue = new Queue<>(new Integer[]{1, 2, 3, 4, 5});
    }

    @Test
    void offer(){
        queue.offer(6);
        assert queue.get(5) == 6;
    }

    @Test
    void pop(){
        int n = queue.pop();
        assert n == 5;
    }

}