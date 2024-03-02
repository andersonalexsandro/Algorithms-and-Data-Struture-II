package io.github.andersonalexsandro.SecundModule.heap;

import java.util.Arrays;

public class MinHeap {

    public void minHeapify(int[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int lowest = i;

        if (l < heapSize && A[l] < A[lowest]) {
            lowest = l;
        }
        if (r < heapSize && A[r] < A[lowest]) {
            lowest = r;
        }
        if (lowest != i) {
            swap(i, lowest, A);
            minHeapify(A, lowest, heapSize);
        }
    }

    private void swap(int i, int lowest, int[] A){
        int temp = A[i];
        A[i] = A[lowest];
        A[lowest] = temp;
    }

    private int left(int i){
        return (2 * i) + 1;
    }

    private int right(int i){
        return (2 * i) + 2;
    }

    public void buildMinHeap(int[] A) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            minHeapify(A, i, A.length);
        }
    }

    public void heapSort(int[] A) {
        buildMinHeap(A);
        for (int i = A.length - 1; i >= 1; i--) {
            swap(0, i, A);
            minHeapify(A, 0, i);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        int[] array = {20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11};
        minHeap.buildMinHeap(array);
        System.out.println(Arrays.toString(array));
        minHeap.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}