package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class testMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        String inputString = "35, 67, 45, 90, 75, 24, 86, 79, 52, 15";

        inputString = inputString.trim();
        inputString = inputString.replace(",", "");
        ArrayList<String> input = new ArrayList<>(List.of(inputString.split(" ")));

        input.forEach(interger -> tree.add(Integer.valueOf(interger)));

        System.out.printf(tree.toString());
        System.out.println("\nIn order");
        System.out.println(tree.inOrder(tree.getRoot()));
        System.out.println("\nPos order");
        System.out.println(tree.posOrder(tree.getRoot()));
        System.out.println("\nPre order");
        System.out.println(tree.preOrder(tree.getRoot()));
        System.out.println();
        System.out.println("\nRever Order");
        System.out.println(tree.reverOrder(tree.getRoot()));
        Integer numberToSeach = Integer.valueOf(input.get(new Random().nextInt(input.size())));
        System.out.println("getting "+ numberToSeach + " key");
        System.out.println(tree.getNode(numberToSeach));
        System.out.println();
        System.out.println("Max value:"+ tree.getMax(tree.getRoot()));
        System.out.println("Min value:"+tree.getMin(tree.getRoot()));
        System.out.println();
        System.out.println();
        System.out.println("Father of:"+numberToSeach + " is:" + tree.getFather(numberToSeach));
        System.out.println();
        System.out.println("Predecessor of:"+numberToSeach + " is:" + tree.getPredecessor(numberToSeach));
        System.out.println();
        System.out.println("Successor of:"+numberToSeach + " is:" + tree.getSuccessor(numberToSeach));
        int numberToRemove = 67;
        System.out.println("removing "+numberToRemove);
        tree.removeNodeByKey(numberToRemove);
        System.out.println(tree.toString());

    }
}
