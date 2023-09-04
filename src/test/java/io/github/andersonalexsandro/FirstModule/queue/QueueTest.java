package io.github.andersonalexsandro.FirstModule.queue;

import io.github.andersonalexsandro.FirstModule.queue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue<Integer> queue;
    int lengthTest;

    @BeforeEach
    void setUp() {
        lengthTest = 20;
        queue = new Queue<>(lengthTest);
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertTrue(queue.isFull());
    }

    @Test
    void isFull() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertEquals(lengthTest, queue.size());
        assertTrue(queue.isFull());
    }

    @Test
    void enqueue() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertTrue(queue.isFull());
    }

    @Test
    void dequeue() {
        assertTrue(queue.isEmpty());
        fullQueue();
        assertTrue(queue.isFull());
        for(int i=0; i< lengthTest; i++) assertEquals(i, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    void fullQueue(){
        for(int i=0; i< lengthTest; i++) queue.enqueue(i);
    }

}