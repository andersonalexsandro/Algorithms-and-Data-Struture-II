package io.github.andersonalexsandro.FirstModule.sort.countingsort;

public class TestMain {
    public static void main(String[] args) {

        Integer[] numbersToSort = {25, 38, 18, 4, 17, 43, 54, 124, 54, 65, 43, 56, 76, 1};

        CountingSort countingSort = new CountingSort(numbersToSort);
        countingSort.sort();
    }
}
