package sarhang.datastructure;

public class DynamicQueueByArray {
    private DynamicArray queue;
    private int count;

    public DynamicQueueByArray() {
        queue = new DynamicArray();
        count = 0;
    }

    public void enqueue(int item) {
        queue.insertFirst(item);
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int item = queue.valueOf(--count);
        queue.removeLast();

        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.valueOf(count-1);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void queueReverse(DynamicQueueByArray queue) {
        DynamicStackByArray tempStack = new DynamicStackByArray();
        while (!queue.isEmpty()) {
            tempStack.push(queue.dequeue());
        }
        while (!tempStack.isEmpty()) {
            queue.enqueue(tempStack.pop());
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(queue.valueOf(i) + " ");
        }
        System.out.println("");
    }
}
