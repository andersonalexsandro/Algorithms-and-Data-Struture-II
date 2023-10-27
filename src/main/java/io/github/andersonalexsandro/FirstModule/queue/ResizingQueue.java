package io.github.andersonalexsandro.FirstModule.queue;

public class ResizingQueue<T> {

    private int size;
    private int head;
    private int tail;
    private Object[] queue;

    public ResizingQueue(int capacity){
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
        queue[tail] = item;
        tail = (tail+1) % queue.length;
        size++;
        if(isFull()) resize(queue.length * 2);
    }

    public T dequeue(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty, cannot dequeue.");
        T item = (T) queue[head];
        head = (head+1) % queue.length;
        size--;
        if(queue.length <= queue.length/4) resize(queue.length/2);
        return item;
    }

    public void resize(int newLength){
        Object[] newQueue = new Object[newLength];
        for(int i=0; i<size; i++){
            newQueue[i] = queue[ (i+head)% queue.length];
        }
        queue = newQueue;
    }

    protected Object[] getQueue(){
        return queue;
    }
}
