package io.github.andersonalexsandro.FirstModule.linked;

public class LinkedList<Type> {

    private Node<Type> first;
    private Node<Type> last;
    private int size;

    public void add(Type item){
        Node element = new Node<Type>(item);
        if(first == null && last == null){
            this.first = element;
            this.last = element;
        }
        else {
            last.next =  element;
            last =  element;
        }
        size++;
    }

    public Type get(int index){
        if(index>=this.size || index<0) throw new IndexOutOfBoundsException();
        Node<Type> atual = first;
        for(int i=0; i<index; i++) if(atual.getNext() != null) atual = atual.getNext();
        return (Type) atual.getValue();
    }

    public int indexOf(Type item){
        Node<Type> atual = this.first;
        for(int i=0; i<size; i++) {
            if(atual.getValue().equals(item)) return i;
            else if(atual.getNext() != null) atual = atual.getNext();
            else break;
        }
        return -1;
    }

    public void remove(Type item){
        Node atual = this.first;
        Node old = null;
        for(int i=0; i<this.size; i++){
            if(atual.getValue().equals(item) && atual.equals(first)){
                first = atual.getNext();
                atual = null;
                size--;
                break;
            }
            if(atual.getValue().equals(item)){
                old.setNext(atual.getNext());
                atual = null;
                size--;
                break;
            }
            if(atual.getNext() != null){
                old = atual;
                atual = atual.getNext();
            }
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    protected class Node<Type> {
        private Type value;
        private Node<Type> next;

        public Node(Type value){
            this.value = value;
        }

        public Type getValue() {
            return value;
        }

        public void setValue(Type value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
