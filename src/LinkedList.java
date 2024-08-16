import java.util.NoSuchElementException;

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

    public void addByIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        else if (index == size) {
            addLast(data);
            return;
        }
        else {
            Node newNode = new Node(data);
            int counter = 0;
            Node current = first;
            while (counter != (size)) {
                if (counter == index) {
                    newNode.next = current;
                    getPrevious(current).next = newNode;
                    size++;
                    return;
                }
                current = current.next;
                counter++;
            }
        }
    }

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first == last)
            first = last = null;
        else {
            var temp = first.next;
            first.next = null;
            first = temp;
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

    public void removeByIndex(int index){
        if (index < 0 || index > (size-1)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == (size-1)) {
            removeLast();
            return;
        } else {
            int counter = 0;
            Node current = first;
            while (counter != (size-1)) {
                if (counter == index) {
                    var previous = getPrevious(current);
                    previous.next = current.next;
                    current.next = null;
                    size--;
                    return;
                }
                current = current.next;
                counter++;
            }
        }
    }

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

    public void reverse () {
        if (first == null) return;

        var next = first;
        var current = first.next;
        while (current != null) {
            var temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }
        last = first;
        first.next = null;
        first = next;
    }
    
    public int getKthFromFirst (int k) {
        if (k<0 || k>size)
            throw new IndexOutOfBoundsException();
        var result = first;
        int counter = 1;
        while (counter != k) {
            result = result.next;
            counter++;
        }
        return result.value;
    }
    //getKthFromLast
    public int getKthFromLast (int k) {
        if (first == null)
            throw new IllegalArgumentException();
        
        var desire = first;
        var lasElement= first;
        for (int i = 0; i < k-1; i++) {
            lasElement = lasElement.next;
            if (lasElement == null)
                throw new IllegalArgumentException();
        }

        while (lasElement != last) {
            desire = desire.next;
            lasElement = lasElement.next;
        }

        return desire.value;
    }
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

    public void printMiddle () {
        if (first == null)
            throw new IllegalStateException();

        if (size%2 == 1) {
            var desire = first;
            for (int i = 1; i < ((size+1)/2); i++) {
                desire = desire.next;
            }
            System.out.print(desire.value);
            System.out.println();
        } else {
            var desire = first;
            for (int i = 1; i < (size/2); i++) {
                desire = desire.next;
            }
            System.out.print(desire.value + " " + desire.next.value);
            System.out.println();
        }
    }
}
