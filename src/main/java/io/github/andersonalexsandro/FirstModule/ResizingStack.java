package io.github.andersonalexsandro.FirstModule;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ResizingStack<T> {
    private Object[] stack;
    private int size;

    public ResizingStack(int length) {
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

    public void resize(int lengh){
        Object[] newStack = new Object[lengh];
        for(int i = 0; i<newStack.length; i++) newStack[i] = stack[i];
        this.stack = newStack;
    }
}
