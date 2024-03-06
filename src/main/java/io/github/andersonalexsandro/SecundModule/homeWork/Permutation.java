package io.github.andersonalexsandro.SecundModule.homeWork;

public class Permutation {
    public static void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; ++i) {
            System.out.printf(" %2d", array[i]);
        }
    }

    public static void exchangeElements(int[] array, int i, int n) {
        int temp = array[i];
        array[i] = array[n];
        array[n] = temp;
    }

    public static void permuteHeap(int size, int[] array, int n) {
        if (n == 1) {
            printArray(array);
            return;
        }
        permuteHeap(size, array, n - 1);
        for (int i = 0; i < (n - 1); ++i) {
            if ((n % 2) == 0) {
                exchangeElements(array, i, n - 1);
            } else {
                exchangeElements(array, 0, n - 1);
            }
            permuteHeap(size, array, n - 1);
            printArray(array);
        }
    }

    public static void permute(int size, int[] array, int n) {
        if (n == size) {
            printArray(array);
            return;
        }
        for (int i = n; i < size; ++i) {
            exchangeElements(array, n, i);
            permute(size, array, n + 1);
            exchangeElements(array, i, n);
        }
    }

    public static void main(String[] args) {
        int size = 9;
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = i;
        }
        Permutation.permuteHeap(size, array, size);
    }
}
