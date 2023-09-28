package io.github.andersonalexsandro.FirstModule.sort.mergeSort;

public class TestMain {
    public static void main(String[] args) {
        Integer[] numbersToSort = {29, 10, 14, 37, 13};
        MergeSort mergeSort = new MergeSort(numbersToSort);
        mergeSort.sort();
    }
}
