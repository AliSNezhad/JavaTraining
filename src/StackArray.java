import java.util.Arrays;
import java.util.EmptyStackException;

public class StackArray {
    private int[] stack;
    private int size;
    private int count = 0;

    public StackArray(int size) {
        this.size = size;
        stack = new int[size];
    }

    public void push( int value ) {
        if ( count == size ) {
            throw new StackOverflowError();
        } else {
            stack[count++] = value;
        }
    }

    public StackArray resize( int newSize ) {
        if( newSize <= count-1) {
            System.out.println("You can not resize the Stack to smaller Stack!");
            return this;
        } else {
            StackArray temp = new StackArray(newSize);
            this.size = newSize;
            int oldCount = count;
            this.count = 0;
            for ( int i = 0; i < oldCount; i++ ) {
                temp.push(stack[i]);
            }
            return temp;
        }
    }

    public int pop() {
        if ( count == 0 ) {
            throw new EmptyStackException();
        }
        return stack[--count];
    }

    public int peek() {
        if ( count == 0 ) {
            throw new EmptyStackException();
        }
        return stack[count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}
