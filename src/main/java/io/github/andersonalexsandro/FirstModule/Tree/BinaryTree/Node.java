package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

public class Node<KeyType extends Comparable<KeyType>> implements Comparable<Node<KeyType>> {
    private KeyType key;
    private Node<KeyType> rightChild;
    private Node<KeyType> leftChild;


    public Node(KeyType key) {
        this.key = key;
        this.rightChild = null;
        this.leftChild = null;
    }

    public KeyType getKey() {
        return key;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public Node<KeyType> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<KeyType> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<KeyType> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<KeyType> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + key +
                ", rightChild=" + rightChild +
                ", leftChild=" + leftChild +
                '}';
    }

    @Override
    public int compareTo(Node<KeyType> anotherNode) {
        return this.key.compareTo(anotherNode.key);
    }
}