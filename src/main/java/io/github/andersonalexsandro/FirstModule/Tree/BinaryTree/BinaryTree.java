package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

public class BinaryTree<Type extends Comparable<Type>> {

    private Node<Type> root;

    public BinaryTree() {
    }

    private void add(Type newValue) {
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
        if(newElement.compareTo(stalker) > 0) stalker.setRightChild(newElement);
        else stalker.setLeftChild(newElement);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}




