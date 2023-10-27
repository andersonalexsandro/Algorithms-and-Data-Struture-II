package io.github.andersonalexsandro.FirstModule.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResizingQueueTest {

    private ResizingQueue<Integer> queue;

    int lengthTest;

    @BeforeEach
    void setUp() {
        lengthTest = 3;
        queue = new ResizingQueue<>(lengthTest);
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertEquals(lengthTest * 2, queue.getQueue().length);

    }

    @Test
    void isFull() {
        fullQueue();
        assertEquals(lengthTest * 2, queue.getQueue().length);
    }

    @Test
    void enqueue() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertEquals(lengthTest * 2, queue.getQueue().length);
        emptyQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeue() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertEquals(lengthTest * 2, queue.getQueue().length);
        emptyQueue();
        assertTrue(queue.isEmpty());
    }

    void fullQueue(){
        for(int i=0; i< lengthTest; i++) queue.enqueue(i);
    }

    void emptyQueue(){
        for(int i=0; i< lengthTest; i++) queue.dequeue();
    }
}