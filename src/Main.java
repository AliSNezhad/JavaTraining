import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.print();
        Array listToArray = list.toArray();

        System.out.println(list.contains(10));
        System.out.println(list.contains(30));
        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(30));

        list.removeFirst();
        list.print();
        list.removeLast();
        list.print();

        System.out.println(list.contains(10));
        System.out.println(list.contains(30));
        System.out.println(list.indexOf(10));
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(30));

        listToArray.print();
    }
}