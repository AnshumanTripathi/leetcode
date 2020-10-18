package problems;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

//  public static void main(String[] args) {
//    System.out.println(Arrays.toString(asteroidCollision(new int[]{1,-2,-2,-2})));
//  }

  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {
      if (stack.empty() || asteroid > 0) {
        stack.push(asteroid);
      } else {
        stack.push(asteroid);
        collide(stack);
      }
    }

    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }

  private void collide(Stack<Integer> stack) {
    if (stack.size() > 1) {
      int n = stack.pop();
      int top = stack.peek();
      if (top < 0) {
        stack.push(n);
        return;
      }
      if (top == -n) {
        stack.pop();
        return;
      }
      if (top > -n) {
        return;
      }
      if (top < -n) {
        stack.pop();
        stack.push(n);
        collide(stack);
      }
    }
  }
}
