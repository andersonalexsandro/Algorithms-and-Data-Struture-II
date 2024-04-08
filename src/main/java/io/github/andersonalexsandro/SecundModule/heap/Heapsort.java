package io.github.andersonalexsandro.SecundModule.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Heapsort {

    public void heapSort(ArrayList<Integer> A){
        MinHeap.buildMinHeap(A);

        for(int i=A.size()-1; i>=1; i--){
            swap(0, i, A);
            MinHeap.minHeapify(A, 0, i);
        }
    }

    private void swap(int i, int j, ArrayList<Integer> A){
        Collections.swap(A, i, j);
    }

    public static void main(String[] args) {
        Heapsort heapSort = new Heapsort();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(20, 8, 16, 14, 9, 7, 10, 1, 2, 4, 11));
        heapSort.heapSort(array);
        System.out.println(array.toString());
    }
}

