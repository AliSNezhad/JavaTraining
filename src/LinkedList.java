import java.util.NoSuchElementException;

// To run and test this class in the Main class, you can copy and paste these codes in the main class:
// LinkedList numbers = new LinkedList();
// now by creating the new LinkedList object you can use the methods of this class

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //add by index in the middle

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    //remove by index in the middle

    private Node getPrevious(Node node) {
        var previous = first;
        while (previous != null) {
            if (previous.next == node) return previous;
            previous = previous.next;
        }
        return null;
    }

    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    public int size () {
        return size;
    }

    public Array toArray () {
        Array array = new Array();
        Node current = first;
        while (current != null) {
            array.insertLast(current.value);
            current = current.next;
        }
        return array;
    }

    //reverse
    //getKthFromFirst
    //getKthFromLast
    //hasLoop
    //createWithLoop

    public void print () {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    //printMiddle
}
