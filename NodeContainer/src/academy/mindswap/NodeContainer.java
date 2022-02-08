package academy.mindswap;

public class NodeContainer<T> {

    private Node<T> head;
    private int length;

    public NodeContainer(){
        head = new Node<T>(null);
        length = 0;
    }

    public void add(T data) {
        Node<T> pointer = head;

        while (pointer.getNext() != null){
            pointer = pointer.getNext();
        }

        pointer.next = new Node(data);
        length++;
        System.out.println("Just createad a new Node " + length);
        System.out.println(data +" stored in node " + length);
    }

    public boolean remove(T data){
        Node <T> pointer = head;

        if( head.getData().equals(data)){
            head = head.next;
            length--;
            System.out.println(data + " removed from head.");
            return true;
        }

        while( pointer.next.getData() != data) {
            pointer = pointer.getNext();
        }

        pointer.next = pointer.next.next;
        length--;

        return true;
    }

    public int size(){
        return length;
    }

    public int indexOf( T data){

        Node <T> pointer = head;

        while (pointer.data != data){
            pointer = pointer.next;
            length++;
        }

        System.out.println(getLength());
        return length;
    }

//    public boolean isEmpty(){
//        return pointer.getData() == null;
//    }

    public int getLength() {
        return length;
    }

    private class Node<T>{
        private Node<T> next;
        private T data;

        public Node(T data){
            this.data = data;
            next = null;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }





}
