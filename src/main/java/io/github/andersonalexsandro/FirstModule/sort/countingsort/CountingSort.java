package io.github.andersonalexsandro.FirstModule.sort.countingsort;

public class CountingSort {

    Integer[] numbersToSort;

    public CountingSort(Integer[] numbersToSort) {
        this.numbersToSort = numbersToSort;
    }

    public void sort(){
        Integer[] sortedNumbers = new Integer[numbersToSort.length];
        Integer[] countingArray = new Integer[getBiggestValue() + 1];
        for(int i=0; i<countingArray.length; i++) countingArray[i] = 0;
        System.out.println("First step: ");
        printArray(countingArray);
        for(int i=0; i<numbersToSort.length; i++) countingArray[numbersToSort[i]]++;
        System.out.println("Second step: ");
        printArray(countingArray);
        for(int i=1; i<countingArray.length; i++){
            countingArray[i] += countingArray[i-1];
        }
        System.out.println("Third step ");
        printArray(countingArray);
        for(int i= numbersToSort.length -1; i >= 0; i--) {
            sortedNumbers[--countingArray[numbersToSort[i]]] = numbersToSort[i];
        }
        System.out.println("Final step: ");
        printArray(countingArray);
        System.out.println("Sorted array: ");
        printArray(sortedNumbers);

    }

    private Integer getBiggestValue(){
        Integer biggestValue = 0;
        for(Integer integer: numbersToSort){
            if(integer > biggestValue){
                biggestValue = integer;
            }
        }
        return biggestValue;
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
