import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addByIndex(0, 0);
        list.addByIndex(1,5);
        list.addByIndex(5,40);
        list.addByIndex(5,35);
        list.print();
        System.out.println(list.size());
        list.reverse();
        list.print();
        System.out.println(list.size());
        list.addFirst(100);
        list.print();
    }
}