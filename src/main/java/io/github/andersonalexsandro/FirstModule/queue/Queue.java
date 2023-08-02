package io.github.andersonalexsandro.FirstModule.queue;

public class Queue<T> {
    private int size;
    private int head;
    private int tail;
    private Object[] queue;

    public Queue(int capacity){
        queue = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
       return size == queue.length;
    }

    public void enqueue(T item){
        if(isFull()) throw new IllegalStateException("Queue is full, cannot enqueue.");
        queue[tail] = item;
        tail = (tail+1) % queue.length;
        size++;
    }

    public T dequeue(){
        if(!isEmpty()){
            T item = (T) queue[head];
            head = (head+1) % queue.length;
            size--;
            return item;
        }
        throw new IllegalStateException("Queue is empty, cannot dequeue.");
    }

    public T peek(){
        if (isEmpty()) throw new IllegalStateException("Queue is empty, cannot peek.");
        return (T) queue[head];
    }

    protected Object[] getQueue(){
        return queue;
    }
}
