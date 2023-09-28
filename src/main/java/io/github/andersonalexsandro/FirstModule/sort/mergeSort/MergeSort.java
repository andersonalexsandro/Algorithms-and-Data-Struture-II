package io.github.andersonalexsandro.FirstModule.sort.mergeSort;

import java.util.Arrays;

public class MergeSort {

    Integer[] numberToSort;

    public MergeSort(Integer[] numberToSort) {
        this.numberToSort = numberToSort;
    }

    public void sort(){
        mergeSort(numberToSort, 0, numberToSort.length);
        printArray(numberToSort);
    }

    private void mergeSort(Integer[] numberToSort, int beginning, int ending){
        if(ending - beginning > 1){
            int middle = (ending + beginning) /2;
            mergeSort(numberToSort, beginning, middle);
            mergeSort(numberToSort, middle, ending);
            merge(numberToSort, beginning, middle, ending);
        }
    }

    private void merge(Integer[] numberToSort, int beginning, int middle, int ending) {
        Integer[] left = Arrays.copyOfRange(numberToSort, beginning, middle);
        Integer[] right = Arrays.copyOfRange(numberToSort, middle, ending);
        int topLeft = 0;
        int topRight = 0;
        for(int i = beginning; i < ending; i++){
            if(topLeft >= left.length){
                numberToSort[i] = right[topRight++];
                continue;
            }
            else if(topRight >= right.length){
                numberToSort[i] = left[topLeft++];
                continue;
            }
            if(left[topLeft] < right[topRight]) numberToSort[i] = left[topLeft++];
            else numberToSort[i] = right[topRight++];
        }
    }

    public void printArray(Integer[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

}
