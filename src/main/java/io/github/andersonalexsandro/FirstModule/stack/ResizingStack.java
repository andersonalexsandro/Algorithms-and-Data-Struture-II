package io.github.andersonalexsandro.FirstModule.stack;

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
        if(size==stack.length) resize(stack.length * 2);
        stack[size++] = item;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T item = (T) stack[--size];
        if (size > 0 && size <= (stack.length) / 4) resize(stack.length / 2);
        return item;
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return (T) stack[size-1];
    }

    public void resize(int newlengh){
        Object[] newStack = new Object[newlengh];
        for(int i = 0; i<size; i++) newStack[i] = stack[i];
        this.stack = newStack;
    }

    protected Object[] getStack(){
        return stack;
    }
}
