package io.github.andersonalexsandro.FirstModule.sort.countingsort;

public class TestMain {
    public static void main(String[] args) {

        Integer[] numbersToSort = {4, 2, 2, 1, 0};

        CountingSort countingSort = new CountingSort(numbersToSort);
        countingSort.sort();
    }
}
