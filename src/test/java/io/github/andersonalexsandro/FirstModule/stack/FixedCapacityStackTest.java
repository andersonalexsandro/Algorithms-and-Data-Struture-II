package io.github.andersonalexsandro.FirstModule.stack;

import io.github.andersonalexsandro.FirstModule.stack.FixedCapacityStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {

    FixedCapacityStack<String> stack;
    int numberOfTest = 10;
    int lenghTest = 10;

    @BeforeEach
    void setUp() {
        stack = new FixedCapacityStack<>(lenghTest);
    }

    @Test
    void push() {
        assertEquals(0, stack.size());
        for(int i=0; i<numberOfTest; i++) stack.push(i+"");
        assertEquals(numberOfTest, stack.size());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push("anoter Item"));
    }

    @Test
    void size(){
        for(int i=0; i<lenghTest; i++){
            assertEquals(i, stack.size());
            stack.push("item");
        }
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        fillStack();
        assertFalse(stack.isEmpty());
    }

    void fillStack(){
        for(int i=0; i<numberOfTest; i++) stack.push(i+"");
    }

    @Test
    void pop() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
        fillStack();
        for(int i =0; i<numberOfTest; i++) stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void peek(){
        assertThrows(EmptyStackException.class, ()-> stack.peek());
        fillStack();
        for(int i=numberOfTest-1; i>=0; i--){
            assertEquals(i+"", stack.peek());
            assertEquals(i+"", stack.pop());
        }
        assertTrue(stack.isEmpty());
    }
}