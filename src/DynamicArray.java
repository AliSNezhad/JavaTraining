
public class DynamicArray {
    private int[] items;

    public DynamicArray() {
        items = new int[0];
    }

    public void insertLast(int newItem) {
        int [] newItems = new int[items.length + 1];
        for (int i=0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        newItems[items.length] = newItem;
        items = newItems;
    }

    public void insertFirst(int newItem) {
        int [] newItems = new int[items.length + 1];
        newItems[0] = newItem;
        for (int i=0; i < items.length; i++) {
            newItems[i+1] = items[i];
        }

        items = newItems;
    }

    public void insertAt(int index, int newItem) {
        if (index < 0 || index > items.length)
            throw new IllegalArgumentException();

        int [] newItems = new int[items.length + 1];
        for (int i=0; i < items.length; i++) {
            if (i < index)
                newItems[i] = items[i];
            else if (i == index) {
                newItems[i] = newItem;
                newItems[i + 1] = items[i];
            }
            else
                newItems[i+1] = items[i];
        }
        items = newItems;
    }

    public void removeFirst() {
        int [] newItems = new int[items.length - 1];
        for (int i=1; i < items.length; i++) {
            newItems[i-1] = items[i];
        }
        items = newItems;
    }

    public void removeLast() {
        int [] newItems = new int[items.length - 1];
        for (int i=0; i < (newItems.length); i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public void removeAt(int index) {
        if (index < 0 || index > items.length)
            throw new IllegalArgumentException();

        int [] newItems = new int[items.length - 1];
        for (int i=0; i < items.length; i++) {
            if (i < index)
                newItems[i] = items[i];
            else if (i == index)
                continue;
            else
                newItems[i-1] = items[i];
        }
        items = newItems;
    }

    public int indexOf(int item) {
        for (int i = 0; i < items.length; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void reverse() {
        int [] newItems = new int[items.length];
        for (int i=0; i < items.length; i++) {
            newItems[items.length-i-1] = items[i];
        }
        items = newItems;
    }

    public int max() {
        int max = items[0];
        for (int i=1; i < items.length; i++) {
            if (max < items[i])
                max = items[i];
        }
        return max;
    }

    public int min() {
        int min = items[0];
        for (int i=1; i < items.length; i++) {
            if (min > items[i])
                min = items[i];
        }
        return min;
    }

    public DynamicArray intersect(DynamicArray other) {
        DynamicArray intersection = new DynamicArray();

        for (int item : items)
            if (other.indexOf(item) >= 0)
                intersection.insertFirst(item);

        return intersection;
    }

    public void print() {
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
