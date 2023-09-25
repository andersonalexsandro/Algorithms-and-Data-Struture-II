package io.github.andersonalexsandro.FirstModule.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<Key extends Comparable<Key>> {

    private Node<Key> root;

    public BinaryTree() {
    }

//    public void removeNodeByKey(Key key){
//        Node<Key> father = null;
//        Node<Key> current = root;
//        while (current != null){
//            if(current.getKey().equals(key)) break;
//            father = current;
//            if(key.compareTo(current.getKey())>0) current = current.getRightChild();
//            else current = current.getLeftChild();
//        }
//        if(current != null){
//            if(current.getRightChild() != null && current.getLeftChild() != null){//has two children
//
//            }else if(current.getLeftChild() != null){//has only left child
//
//            }else if(current.getRightChild() != null){//has only right child
//                Node<Key> substituteFather = current;
//                Node<Key> substitute = current.getRightChild();
//                while (substitute != null){
//                    substituteFather = substitute;
//                    substitute = substitute.getLeftChild();
//                }
//
//                if(father.getRightChild() != null && father.getRightChild().equals(current)) father.setRightChild(substituteFather);
//                else father.setLeftChild(substituteFather);
//                substituteFather = null;
//
//            }else{//has no children
//                if(current.compareTo(father) > 0) father.setRightChild(null);
//                else father.setLeftChild(null);
//            }
//        }
//        else throw new IndexOutOfBoundsException("There isn't node with key"+key);
//    }

    public Node<Key> getNodeByKey(Key key){
        Node<Key> current = root;
        while (true){
            if(current.getKey().equals(key)) return current;
            if(key.compareTo(current.getKey())>0) current = current.getRightChild();
            else current = current.getLeftChild();
            if(current == null) return null;
        }
    }

    public void add(Key newValue) {
        Node<Key> newElement = new Node<>(newValue);
        Node<Key> current = root;
        Node<Key> stalker = null;

        while (current != null){
            stalker = current;
            if(newElement.compareTo(current) > 0) current = current.getRightChild();
            else current = current.getLeftChild();
        }
        if(stalker == null) root = newElement;
        else if(newElement.compareTo(stalker) > 0) stalker.setRightChild(newElement);
            else stalker.setLeftChild(newElement);
    }

    public List<Key> inOrder(Node<Key> beggining) {
        List<Key> inOrderList = new ArrayList<>();
        inOrderTraversal(beggining, inOrderList);
        return inOrderList;
    }

    private void inOrderTraversal(Node<Key> current, List<Key> inOrderList) {
        if (current != null) {
            inOrderTraversal(current.getLeftChild(), inOrderList);
            inOrderList.add(current.getKey());
            inOrderTraversal(current.getRightChild(), inOrderList);
        }
    }

    public List<Key> reverOrder(Node<Key> begging){
        List<Key> reverOrderList = new ArrayList<>();
        reverOrderTraversal(begging, reverOrderList);
        return reverOrderList;
    }

    private void reverOrderTraversal(Node<Key> begging, List<Key> reverOrderList) {
        if(begging != null){
            reverOrderTraversal(begging.getRightChild(), reverOrderList);
            reverOrderList.add(begging.getKey());
            reverOrderTraversal(begging.getLeftChild(), reverOrderList);
        }
    }


    public List<Key> preOrder(Node<Key> begging){
        List<Key> preOrderList = new ArrayList<>();
        preOrderTraversal(begging, preOrderList);
        return preOrderList;
    }

    private void preOrderTraversal(Node<Key> current , List<Key> list){
        if(current != null){
            list.add(current.getKey());
            preOrderTraversal(current.getLeftChild(), list);
            preOrderTraversal(current.getRightChild(), list);
        }
    }

    public List<Key> posOrder(Node<Key> begging){
        List<Key> list = new ArrayList<>();
        posOrderTraversal(begging, list);
        return list;
    }

    private void posOrderTraversal(Node<Key> current, List<Key> list){
        if(current != null){
            posOrderTraversal(current.getLeftChild(), list);
            posOrderTraversal(current.getRightChild(), list);
            list.add(current.getKey());
        }
    }

    public Node<Key> getRoot() {
        return root;
    }

    //Implemented by CHAT-GPT(3.5)
    @Override
    public String toString() {
        if (root == null) {
            return "Tree is empty";
        }

        StringBuilder sb = new StringBuilder();
        printTree(root, sb, "", "");
        return sb.toString();
    }

    private void printTree(Node<Key> node, StringBuilder sb, String prefix, String childrenPrefix) {
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




