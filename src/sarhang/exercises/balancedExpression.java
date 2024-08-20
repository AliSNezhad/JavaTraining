package sarhang.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class balancedExpression {
    private final List<Character> leftBrackets
            = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', ']', '}');
    private String expression = "";

    public balancedExpression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (leftBrackets.contains(c)) {
                stack.push(c);
            }

            if (rightBrackets.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                var top = stack.pop();
                if (leftBrackets.indexOf(top) != rightBrackets.indexOf(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
