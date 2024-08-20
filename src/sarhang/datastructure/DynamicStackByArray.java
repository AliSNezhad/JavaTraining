package sarhang.datastructure;

import java.util.EmptyStackException;

public class DynamicStackByArray {
    private DynamicArray stack;
    private int count;
    private DynamicArray minStack;
    private DynamicArray maxStack;

    public DynamicStackByArray() {
        stack = new DynamicArray();
        minStack = new DynamicArray();
        maxStack = new DynamicArray();
        count = 0;
    }

    public void push( int value ) {
        stack.insertFirst(value);

        if (isEmpty()) {
            minStack.insertFirst(value);
        } else if (value < minStack.valueOf(0)){
            minStack.insertFirst(value);
        }

        if (isEmpty()) {
            maxStack.insertFirst(value);
        } else if (value > maxStack.valueOf(0)){
            maxStack.insertFirst(value);
        }

        count++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedValue = stack.valueOf(0);
        stack.removeFirst();
        count--;

        if (minStack.valueOf(0) == poppedValue) {
            minStack.removeFirst();
        }

        if (maxStack.valueOf(0) == poppedValue) {
            maxStack.removeFirst();
        }

        return poppedValue;
    }

    public int peek() {
        if ( isEmpty() ) {
            throw new EmptyStackException();
        }
        return stack.valueOf(0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int min() {
        return minStack.valueOf(0);
    }

    public int max() {
        return maxStack.valueOf(0);
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(stack.valueOf(i) + " ");
        }
        System.out.println("");
    }
}
