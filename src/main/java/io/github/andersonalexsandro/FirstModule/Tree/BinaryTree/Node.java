package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

public class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {
    private Type key;
    private Node<Type> rightChild;
    private Node<Type> leftChild;
    private Node<Type> father;


    public Node(Type key) {
        this.key = key;
        this.rightChild = null;
        this.leftChild = null;
    }

    public Type getKey() {
        return key;
    }

    public void setKey(Type key) {
        this.key = key;
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
                "value=" + key +
                ", rightChild=" + rightChild +
                ", leftChild=" + leftChild +
//                ", father=" + father +
                '}';
    }

    @Override
    public int compareTo(Node<Type> anotherNode) {
        return this.key.compareTo(anotherNode.key);
    }
}