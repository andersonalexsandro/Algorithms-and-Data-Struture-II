package io.github.andersonalexsandro.FirstModule.linked;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    private LinkedList<Integer> linkedList;
    private int numberOfTests;
    @BeforeEach
    void setUpTest() {
        linkedList = new LinkedList<>();
        numberOfTests = 10;
    }

    @Test
    void addTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(i + 1, linkedList.getSize());
        }
    }

    @Test
    void getTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(Integer.valueOf(i), linkedList.get(i));
        }
    }

    @Test
    void indexOfTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(i, linkedList.indexOf(i));
        }
    }

    @Test
    void removeTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
        }

        for (int i = 0; i < numberOfTests; i++) {
            linkedList.remove(i);
            assertEquals(numberOfTests - (i + 1), linkedList.getSize());
            assertEquals(-1, linkedList.indexOf(i));
        }
    }

    @Test
    void isEmptyTest() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(42);
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void getFirstTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(0, linkedList.getFirst().getValue());
        }
    }

    @Test
    void getLastTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(i, linkedList.getLast().getValue());
        }
    }

    @Test
    void getSizeTest() {
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(i);
            assertEquals(i + 1, linkedList.getSize());
        }
    }
}