package problems;

import java.util.Stack;

public class MaxAreaHistogram {

  public static void main(String[] args) {
//    System.out.println(largestRectangleArea(new int[]{ 6, 2, 5, 4, 5, 1, 6 }));
//    System.out.println(largestRectangleArea(new int[]{ 1,2,4 }));
    System.out.println(largestRectangleArea(new int[]{ 2,1,5,6,2,3 }));
//    System.out.println(largestRectangleArea(new int[]{ 0,0 }));
  }

  public static int largestRectangleArea(int[] heights) {
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
