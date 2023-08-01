package io.github.andersonalexsandro.FirstModule;

import java.lang.reflect.Array;

public class FixedCapacityStack<T> {
    private Class<T> type;
    private T[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int length, Class<T> type) {
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
    }

    public T pop(){
        T item = stack[size];
        stack[size] = null;
        return item;
    }

}
