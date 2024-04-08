package io.github.andersonalexsandro.SecundModule.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinHeap {

    private ArrayList<Integer> priorityQueue;

    public MinHeap(ArrayList<Integer> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public int extractMin(ArrayList<Integer> A){
        int lowest = A.get(0);
        Collections.swap(A, 0, A.size()-1);
        A.remove(A.size()-1);
        minHeapify(A, 0, A.size());
        return lowest;
    }

    public void insert(int value){
        this.priorityQueue.add(value);
        this.priorityQueue.set(this.priorityQueue.size()-1, Integer.MAX_VALUE);
        decrease(this.priorityQueue.size()-1, value);
    }

    public void decrease(int index, int newValue){
        if (this.priorityQueue.get(index) < newValue) throw new RuntimeException("New value is greater than current value");
        this.priorityQueue.set(index, newValue);
        while(parent(index) >= 0 && this.priorityQueue.get(index) < this.priorityQueue.get(parent(index))){
            Collections.swap(this.priorityQueue, parent(index), index);
            index = parent(index);
        }
    }

    public static void minHeapify(ArrayList<Integer> A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int lowest = i;

        if (l < heapSize && A.get(l) < A.get(lowest)) {
            lowest = l;
        }
        if (r < heapSize && A.get(r) < A.get(lowest)) {
            lowest = r;
        }
        if (lowest != i) {
            Collections.swap(A, i, lowest);
            minHeapify(A, lowest, heapSize);
        }
    }

    private static int left(int i){
        return (2 * i) + 1;
    }

    private static int right(int i){
        return (2 * i) + 2;
    }

    private static int parent(int i){
        return (i-1)/2;
    }

    public static void buildMinHeap(ArrayList<Integer> A) {
        for (int i = ((A.size()-1)/ 2); i >= 0; i--) {
            minHeapify(A, i, A.size());
        }
    }

    public static void heapSort(ArrayList<Integer> A) {
        buildMinHeap(A);
        for (int i = A.size() - 1; i >0; i--) {
            Collections.swap(A, 0, i);
            minHeapify(A, 0, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11));
        MinHeap.buildMinHeap(array);
        System.out.println(array.toString());
        MinHeap.heapSort(array);
        System.out.println(array.toString());
    }
}