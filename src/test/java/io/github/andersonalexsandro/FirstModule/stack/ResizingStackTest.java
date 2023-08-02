package io.github.andersonalexsandro.FirstModule.stack;

import io.github.andersonalexsandro.FirstModule.stack.ResizingStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ResizingStackTest {

    ResizingStack<String> stack;

    int lenghTest = 10;

    @BeforeEach
    void setUp() {
        stack = new ResizingStack<>(lenghTest);
    }

    @Test
    void push() {
        assertEquals(0, stack.size());
        for (int i = 0; i < lenghTest; i++) stack.push(i + "");
        assertEquals(lenghTest, stack.size());

        System.out.println(stack.getStack().length);
        stack.push("last item");
        assertEquals(lenghTest * 2, stack.getStack().length);
    }

    @Test
    void size() {
        for (int i = 0; i < lenghTest; i++) {
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

    @Test
    void pop() {
       assertEmptyStackException();
        fillStack();
        for(int i=0; i < stack.getStack().length/4; i++){
            stack.pop();
        }
        assertTrue(lenghTest/4 <= stack.getStack().length);
    }

    @Test
    void peek() {
        assertEmptyStackException();
        fillStack();
        for (int i = lenghTest - 1; i >= 0; i--) {
            assertEquals(i + "", stack.peek());
            assertEquals(i + "", stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

    void fillStack() {
        for (int i = 0; i < lenghTest; i++) stack.push(i + "");
    }

    void assertEmptyStackException(){
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
}