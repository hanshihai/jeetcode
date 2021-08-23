package jeet.code.design;

import java.util.Stack;

public class SQueue {

    private Stack<Integer> currentStack = null;

    /** Initialize your data structure here. */
    public SQueue() {
        currentStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> buffer = new Stack<>();
        while (!currentStack.isEmpty()) {
            buffer.push(currentStack.pop());
        }
        buffer.push(x);
        currentStack.empty();
        while(!buffer.isEmpty()) {
            currentStack.push(buffer.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return currentStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return currentStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return currentStack.empty();
    }
}
