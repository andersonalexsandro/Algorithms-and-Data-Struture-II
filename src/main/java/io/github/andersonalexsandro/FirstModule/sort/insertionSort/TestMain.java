package io.github.andersonalexsandro.FirstModule.sort.insertionSort;

public class TestMain {
    public static void main(String[] args) {
        Integer[] numbersToSort = {29, 10, 14, 37, 13};
        InsertionSort insertionSort = new InsertionSort(numbersToSort);
        insertionSort.sort();
    }
}
