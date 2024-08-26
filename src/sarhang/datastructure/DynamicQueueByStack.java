package sarhang.datastructure;

import java.util.EmptyStackException;

public class DynamicQueueByStack {
    private DynamicStackByArray queue = new DynamicStackByArray();
    private DynamicStackByArray stack = new DynamicStackByArray();

    public void enqueue(int value) {
        queue.push(value);
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        moveQueueToStack();
        return stack.pop();
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        moveQueueToStack();
        return stack.peek();
    }

    private void moveQueueToStack() {
        if (stack.isEmpty()) {
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}
