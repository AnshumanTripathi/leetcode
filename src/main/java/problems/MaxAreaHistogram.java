package problems;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class MaxAreaHistogram {

  public int largestRectangleArea(int[] heights) {
    if (heights.length == 0) {
      return 0;
    }
    if (heights.length == 1) {
      return heights[0];
    }
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int i = 0;
    while(i < heights.length) {
      if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
        stack.push(i++);
      } else {
        int top = stack.pop();
        maxArea = Math.max(maxArea, heights[top] * (stack.empty() ? i : i - stack.peek() - 1));
      }
    }

    while (!stack.isEmpty()) {
      int top = stack.pop();
      maxArea = Math.max(maxArea,  heights[top] * (stack.empty() ? i : i - stack.peek() - 1));
    }
    return maxArea;
  }
}
