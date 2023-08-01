package io.github.andersonalexsandro.FirstModule;

import java.lang.reflect.Array;

public class ResizingStack<T> {
    private Class<T> type;
    private T[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public ResizingStack(int length, Class<T> type) {
        this.type = type;
        this.stack = (T[]) Array.newInstance(type, length);
        this.size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void push(T item){
        stack[size] = item;
        size++;
        if(size == stack.length) resize(stack.length * 2);
    }

    public T pop(){
        if(isEmpty()) throw new IndexOutOfBoundsException();
        T item = stack[size];
        stack[size] = null;
        if(size>0 && size == stack.length/2) resize(stack.length/2);
        return item;
    }

    public void resize(int lengh){
        T[] newStack = (T[]) Array.newInstance(type, lengh);
        for(int i = 0; i<newStack.length; i++) newStack[i] = stack[i];
        this.stack = newStack;
    }
}
