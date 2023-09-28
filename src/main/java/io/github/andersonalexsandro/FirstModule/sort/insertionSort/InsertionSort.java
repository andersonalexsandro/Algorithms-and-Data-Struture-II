package io.github.andersonalexsandro.FirstModule.sort.insertionSort;

public class InsertionSort {
    Integer[] numbersToSort;

    public InsertionSort(Integer[] numbersToSort) {
        this.numbersToSort = numbersToSort;
    }

    public void sort(){
        for(int i =1; i < numbersToSort.length; i++){
            int temporaryVariable = numbersToSort[i];
            int j = i -1;
            while (temporaryVariable < numbersToSort[j]){
                numbersToSort[j+1] = numbersToSort[j];
                j--;
                if(j < 0) break;
            }
            numbersToSort[j+1] = temporaryVariable;
        }
        printArray(numbersToSort);
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
