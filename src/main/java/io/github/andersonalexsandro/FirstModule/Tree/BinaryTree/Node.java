package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

public class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {
    private Type value;
    private Node<Type> rightChild;
    private Node<Type> leftChild;
    private Node<Type> father;


    public Node(Type value) {
        this.value = value;
        this.rightChild = null;
        this.leftChild = null;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public Node<Type> getFather() {
        return father;
    }

    public void setFather(Node<Type> father) {
        this.father = father;
    }

    public Node<Type> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<Type> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<Type> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<Type> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", rightChild=" + rightChild +
                ", leftChild=" + leftChild +
                ", father=" + father +
                '}';
    }

    @Override
    public int compareTo(Node<Type> anotherNode) {
        return this.value.compareTo(anotherNode.value);
    }
}