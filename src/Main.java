import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //FizzBuzz game = new FizzBuzz();
        //game.run();
        Array ali = new Array();
        ali.insertFirst(5);
        ali.insertLast(6);
        ali.insertLast(7);
        ali.insertFirst(4);
        ali.insertAt(0,3);
        ali.insertFirst(1);
        ali.insertAt(1,2);

        ali.print();
    }
}