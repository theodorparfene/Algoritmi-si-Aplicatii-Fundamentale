package StivaCozi;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push (int x) {
        stack.push(x);
        if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop () {
        int x = stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
