package jeet.code.design;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> elements = new ArrayList<>();
    private int min = 0;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if (elements.size() > 0) {
            if (elements.get(min) > val) {
                min = elements.size();
            }
        }
        elements.add(val);
    }

    private void reCalculate() {
        int initValue = 0;
        for(int i=0;i<elements.size()-1;i++) {
            if (elements.get(i) < initValue) {
                initValue = elements.get(i);
                min = i;
            }
        }
    }
    public void pop() {
        if (elements.size() == 0) {
            return;
        }
        if (min == elements.size()-1) {
            reCalculate();
        }
        elements.remove(elements.size()-1);
    }

    public int top() {
        if (elements.size() == 0) {
            return 0;
        }
        return elements.get(elements.size()-1);
    }

    public int getMin() {
        if (elements.size() == 0) {
            return 0;
        }
        if (elements.size() == 1) {
            return elements.get(0);
        }
        return elements.get(min);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(0);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.getMin();
    }
}
