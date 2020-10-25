package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {

  private static final List<String> output = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return output;
    }
    if (n == 1) {
      output.add("()");
      return output;
    }
    getCombos("", n , n);
    return output;
  }

  public static void getCombos(String input, int left, int right) {
    if (left == 0 && right == 0) {
      output.add(input);
      return;
    }
    if (left > 0) {
      getCombos(input + "(", left-1, right);
    }
    if (right> left) {
      getCombos(input+ ")", left, right-1);
    }
  }
}
