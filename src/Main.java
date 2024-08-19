import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StackArray myStack = new StackArray(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack = myStack.resize(5);
        myStack.push(4);
        myStack = myStack.resize(4);
        myStack = myStack.resize(3);
    }
}