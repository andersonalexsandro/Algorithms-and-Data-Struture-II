package io.github.andersonalexsandro.FirstModule;

import java.util.EmptyStackException;

public class FixedCapacityStack<T> {
    private Object[] stack;
    private int size;

    public FixedCapacityStack(int length) {
        this.stack = new Object[length];
        this.size = 0;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public int size(){
        return size;
    }

    public void push(T item){
        stack[size++] = item;
    }

    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        return (T) stack[--size];
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return (T) stack[size-1];
    }
}
