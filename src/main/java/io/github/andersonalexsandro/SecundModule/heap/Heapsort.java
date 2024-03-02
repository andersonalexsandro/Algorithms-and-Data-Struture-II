package io.github.andersonalexsandro.SecundModule.heap;

import java.util.Arrays;

public class Heapsort {

    private MinHeap minHeap = new MinHeap();

    public void heapSort(int[]A){
        minHeap.buildMinHeap(A);

        for(int i=A.length-1; i>=1; i--){
            swap(0, i, A);
            minHeap.minHeapify(A, 0, i);
        }
    }

    private void swap(int i, int j, int[] A){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Heapsort heapSort = new Heapsort();
        int[] array = {20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11};
        heapSort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
