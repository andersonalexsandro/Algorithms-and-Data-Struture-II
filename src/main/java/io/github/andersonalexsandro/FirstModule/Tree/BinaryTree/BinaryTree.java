package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<Type extends Comparable<Type>> {

    private Node<Type> root;

    public BinaryTree() {
    }

    public void add(Type newValue) {
        Node<Type> newElement = new Node<>(newValue);
        Node<Type> current = root;
        Node<Type> stalker = null;

        while (current != null){
            stalker = current;
            if(newElement.compareTo(current) > 0) current = current.getRightChild();
            else current = current.getLeftChild();
        }
        newElement.setFather(stalker);
        if(stalker == null) root = newElement;
        else if(newElement.compareTo(stalker) > 0) stalker.setRightChild(newElement);
            else stalker.setLeftChild(newElement);
    }

    public List<Type> inOrder(Node<Type> current) {
        List<Type> inOrderList = new ArrayList<>();
        inOrderTraversal(current, inOrderList);
        return inOrderList;
    }

    private void inOrderTraversal(Node<Type> node, List<Type> inOrderList) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild(), inOrderList);
            inOrderList.add(node.getKey());
            inOrderTraversal(node.getRightChild(), inOrderList);
        }
    }

    public Node<Type> getRoot() {
        return root;
    }

    //Implemented by CHAT-GPT(3.5)
    @Override
    public String toString() {
        if (root == null) {
            return "Árvore vazia";
        }

        StringBuilder sb = new StringBuilder();
        printTree(root, sb, "", "");
        return sb.toString();
    }

    private void printTree(Node<Type> node, StringBuilder sb, String prefix, String childrenPrefix) {
        if (node != null) {
            sb.append(prefix);
            sb.append(node.getKey());
            sb.append('\n');

            if (node.getLeftChild() != null || node.getRightChild() != null) {
                if (node.getLeftChild() != null && node.getRightChild() != null) {
                    printTree(node.getRightChild(), sb, childrenPrefix + "├── right: ", childrenPrefix + "│   ");
                    printTree(node.getLeftChild(), sb, childrenPrefix + "└── left: ", childrenPrefix + "    ");
                } else if (node.getRightChild() != null) {
                    printTree(node.getRightChild(), sb, childrenPrefix + "└── right: ", childrenPrefix + "    ");
                } else if (node.getLeftChild() != null) {
                    printTree(node.getLeftChild(), sb, childrenPrefix + "└── left: ", childrenPrefix + "    ");
                }
            }
        }
    }
}




