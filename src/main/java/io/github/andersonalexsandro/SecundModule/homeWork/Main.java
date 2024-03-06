package io.github.andersonalexsandro.SecundModule.homeWork;

public class Main {
    public static void main(String[] args) {
        int size = 4;
        if (args.length < 1) return;
        try {
            size = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Defaulting size to 4.");
            size = 4;
        }
        if (size < 1) size = 4;
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = i + 1;
        }
        Permutation.permute(size, array, 7);
        System.out.println();
    }
}
