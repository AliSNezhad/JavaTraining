package sarhang.datastructure;

public class PriorityQueueByArray {
    private DynamicArray pQueue;

    public PriorityQueueByArray() {
        pQueue = new DynamicArray();
    }

    public void enqueue(int item) {
        if (pQueue.size() <= 0) {
            pQueue.insertFirst(item);
            return;
        } else if (pQueue.valueOf(pQueue.size() - 1) <= item) {
            pQueue.insertLast(item);
        } else {
            for (int i = 0; i < pQueue.size(); i++) {
                if (pQueue.valueOf(i) >= item) {
                    pQueue.insertAt(i, item);
                    return;
                }
            }
        }
    }

    public int dequeue() {
        int poppedVariable = pQueue.valueOf(0);
        pQueue.removeFirst();
        return poppedVariable;
    }

    public String toString() {
        return pQueue.toString();
    }
}
