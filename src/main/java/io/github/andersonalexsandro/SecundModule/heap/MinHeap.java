package io.github.andersonalexsandro.SecundModule.heap;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == heap.length) throw new IllegalStateException();
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getMin() {
        if (size == 0) throw new IllegalStateException();
        return heap[0];
    }

    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    public void buildHeap(int[] elements){

        this.heap = elements;
        for(int i= (heap.length/2)-1; i > 0; i--){
            int left = heap[(i * 2)+1];
            int right = heap[(i *2) + 2];
            if(left < heap[i] && left < right){
                heapifyUp((i * 2)+1);
            }
            else{
                heapifyUp((i *2) + 2);
            }
        }
    }

    public static void main(String args[]){
        MinHeap minHeap = new MinHeap(11);
        int[] elementes = {20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11};

        for(int i=0; i<elementes.length; i++) {
            minHeap.add(elementes[i]);
        }
        minHeap.printHeap();
        minHeap.buildHeap(elementes);
        minHeap.printHeap();
    }
}