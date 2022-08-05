package practice.random;

import java.util.Stack;

/**
 * Created by Anindita Banik on 8/5/22.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if(stack.isEmpty())
            stack.push(val);
        else if(stack.peek()>=val)
            stack.push(val);
        else{
            int element = stack.pop();
            stack.push(val);
            stack.push(element);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
