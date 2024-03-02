package io.github.andersonalexsandro.SecundModule.heap;

import java.util.Arrays;

public class MaxHeap {

    public void maxHeapify(int[] A, int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int biggest = i;

        if (l < heapSize && A[l] > A[biggest]) {
            biggest = l;
        }
        if (r < heapSize && A[r] > A[biggest]) {
            biggest = r;
        }
        if (biggest != i) {
            swap(i, biggest, A);
            maxHeapify(A, biggest, heapSize);
        }
    }

    private void swap(int i, int biggest, int[] A){
        int temp = A[i];
        A[i] = A[biggest];
        A[biggest] = temp;
    }

    private int left(int i){
        return (2 * i) + 1;
    }

    private int right(int i){
        return (2 * i) + 2;
    }

    public void buildMaxHeap(int[] A) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i, A.length);
        }
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        int[] array = {20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11};
        maxHeap.buildMaxHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
