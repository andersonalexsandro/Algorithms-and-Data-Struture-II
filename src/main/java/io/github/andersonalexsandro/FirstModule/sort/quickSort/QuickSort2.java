package io.github.andersonalexsandro.FirstModule.sort.quickSort;



public class QuickSort2 {

    Integer[] numbersToSort;

    public QuickSort2(Integer[] numbersToSort) {
        this.numbersToSort = numbersToSort;
    }

    public void sort(){
        quickSort(numbersToSort, 0, numbersToSort.length-1);
        System.out.println("Sort 2:");
        printArray(numbersToSort);
    }

    private void quickSort(Integer[] numbersToSort, int beginning, int ending) {
        if(beginning < ending){
            int pivot = partition(numbersToSort, beginning, ending);
            quickSort(numbersToSort, beginning, pivot-1);
            quickSort(numbersToSort, pivot+1, ending);
        }
    }

    private int partition(Integer[] numbersToSort, int begnning, int ending){
        int pivot = numbersToSort[ending];
        int i = begnning -1;
        for(int j = begnning; j < ending; j++){
            if(numbersToSort[j] < pivot){
                i++;
                swap(numbersToSort, i, j);
            }
        }
        swap(numbersToSort, i+1, ending);
        return i+1;
    }

    private void swap(Integer[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void printArray(Integer[] numbersToSort) {
        System.out.print("[ ");
        for (int i = 0; i < numbersToSort.length; i++) {
            System.out.print(numbersToSort[i]);
            if (i < numbersToSort.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

}
