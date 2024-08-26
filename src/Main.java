import sarhang.datastructure.DynamicQueueByStack;

public class Main {
    public static void main(String[] args) {
        DynamicQueueByStack queue = new DynamicQueueByStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        int first = queue.dequeue();
        System.out.println(first);
        queue.enqueue(5);
        int second = queue.dequeue();
        System.out.println(second);
        System.out.println(queue.peek());
    }
}