package sarhang.datastructure;

import java.util.Arrays;

public class DynamicArray {
    private int[] dynamicArray;

    public DynamicArray() {
        dynamicArray = new int[0];
    }

    public void insertLast(int newItem) {
        int [] newItems = new int[dynamicArray.length + 1];
        for (int i = 0; i < dynamicArray.length; i++) {
            newItems[i] = dynamicArray[i];
        }
        newItems[dynamicArray.length] = newItem;
        dynamicArray = newItems;
    }

    public void insertFirst(int newItem) {
        int [] newItems = new int[dynamicArray.length + 1];
        newItems[0] = newItem;
        for (int i = 0; i < dynamicArray.length; i++) {
            newItems[i+1] = dynamicArray[i];
        }

        dynamicArray = newItems;
    }

    public void insertAt(int index, int newItem) {
        if (index < 0 || index > dynamicArray.length)
            throw new IllegalArgumentException();

        int [] newItems = new int[dynamicArray.length + 1];
        for (int i = 0; i < dynamicArray.length; i++) {
            if (i < index)
                newItems[i] = dynamicArray[i];
            else if (i == index) {
                newItems[i] = newItem;
                newItems[i + 1] = dynamicArray[i];
            }
            else
                newItems[i+1] = dynamicArray[i];
        }
        dynamicArray = newItems;
    }

    public void removeFirst() {
        int [] newItems = new int[dynamicArray.length - 1];
        for (int i = 1; i < dynamicArray.length; i++) {
            newItems[i-1] = dynamicArray[i];
        }
        dynamicArray = newItems;
    }

    public void removeLast() {
        int [] newItems = new int[dynamicArray.length - 1];
        for (int i=0; i < (newItems.length); i++) {
            newItems[i] = dynamicArray[i];
        }
        dynamicArray = newItems;
    }

    public void removeAt(int index) {
        if (index < 0 || index > dynamicArray.length)
            throw new IllegalArgumentException();

        int [] newItems = new int[dynamicArray.length - 1];
        for (int i = 0; i < dynamicArray.length; i++) {
            if (i < index)
                newItems[i] = dynamicArray[i];
            else if (i == index)
                continue;
            else
                newItems[i-1] = dynamicArray[i];
        }
        dynamicArray = newItems;
    }

    public int indexOf(int item) {
        for (int i = 0; i < dynamicArray.length; i++)
            if (dynamicArray[i] == item)
                return i;

        return -1;
    }

    public int valueOf(int index) {
        return dynamicArray[index];
    }

    public int size() {
        return dynamicArray.length;
    }

    public void reverse() {
        int [] newItems = new int[dynamicArray.length];
        for (int i = 0; i < dynamicArray.length; i++) {
            newItems[dynamicArray.length-i-1] = dynamicArray[i];
        }
        dynamicArray = newItems;
    }

    public int max() {
        int max = dynamicArray[0];
        for (int i = 1; i < dynamicArray.length; i++) {
            if (max < dynamicArray[i])
                max = dynamicArray[i];
        }
        return max;
    }

    public int min() {
        int min = dynamicArray[0];
        for (int i = 1; i < dynamicArray.length; i++) {
            if (min > dynamicArray[i])
                min = dynamicArray[i];
        }
        return min;
    }

    public DynamicArray intersect(DynamicArray other) {
        DynamicArray intersection = new DynamicArray();

        for (int item : dynamicArray)
            if (other.indexOf(item) >= 0)
                intersection.insertFirst(item);

        return intersection;
    }

    @Override
    public String toString() {
        return Arrays.toString(dynamicArray);
    }

    public void print() {
        for (int item : dynamicArray) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
