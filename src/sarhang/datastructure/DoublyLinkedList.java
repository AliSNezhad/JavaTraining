package sarhang.datastructure;

// In construction
public class DoublyLinkedList<T> {

    private class Node<T> {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) { this.data = data; }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            first = last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            first = last =  newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public void addByIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            addFirst(data);
            return;
        } else if(index == size) {
            addLast(data);
            return;
        } else {
            
        }
    }
}
