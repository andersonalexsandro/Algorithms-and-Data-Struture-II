package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class testMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        String inputString = "35, 67, 45, 90, 75, 24, 86, 79, 52, 15";

        inputString = inputString.trim();
        inputString = inputString.replace("," , "");
        ArrayList<String> input = new ArrayList<>(List.of(inputString.split(" ")));

        input.forEach(interger -> tree.add(Integer.valueOf(interger)));

        System.out.printf(tree.toString());
        System.out.println(tree.inOrder(tree.getRoot()));
    }
}
