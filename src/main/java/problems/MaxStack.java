package problems;

import java.util.Stack;

// https://leetcode.com/problems/max-stack/
public class MaxStack {
  Stack<Integer> stack = new Stack<>();
  Stack<Integer> maxStack = new Stack<>();

  public void push(int x) {
    if (maxStack.isEmpty() || x >= maxStack.peek()) {
      maxStack.push(x);
    }
    stack.push(x);
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (!maxStack.isEmpty() && stack.peek().equals(maxStack.peek())) {
      maxStack.pop();
    }
    return stack.pop();
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public int peekMax() {
    if (maxStack.isEmpty()) {
      return stack.peek();
    }
    return maxStack.peek();
  }

  public int popMax() {
    if (maxStack.isEmpty() || stack.isEmpty()) {
      return -1;
    }
    int maxValue = maxStack.pop();
    Stack<Integer> temp = new Stack<>();
    while (stack.peek() != maxValue) {
      temp.push(stack.pop());
    }

    stack.pop();

    while(!temp.isEmpty()) {
      if (maxStack.isEmpty()  || temp.peek() >= maxStack.peek()) {
        maxStack.push(temp.peek());
      }
      stack.push(temp.pop());
    }
    return maxValue;
  }
}
