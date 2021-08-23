package jeet.code.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class QStack {

    private Deque<Integer> currentQueue = null;
    /** Initialize your data structure here. */
    public QStack() {
        currentQueue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        currentQueue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int popElement = currentQueue.getLast();
        currentQueue.removeLast();
        return popElement;
    }

    /** Get the top element. */
    public int top() {
        return currentQueue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return currentQueue.isEmpty();
    }

    public static void main(String[] args) {
        QStack stack = new QStack();
        for(int i=0;i<5;i++) {
            stack.push(i);
        }
        int pop = stack.pop();
        int top = stack.top();
        stack.empty();
    }
}
