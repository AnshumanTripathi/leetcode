package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
  private static final Map<Character, Character> brackets = new HashMap<>();

  public ValidParenthesis() {
    brackets.put(')', '(');
    brackets.put(']', '[');
    brackets.put('}', '{');
  }

  public boolean isValid(String s) {
    final Stack<Character> charStack = new Stack<>();
    if (s.length() == 0) {
      return true;
    }
    for (char bracket : s.toCharArray()) {
      if (brackets.containsKey(bracket)) {
        if (charStack.isEmpty()) {
          return false;
        }
        char ch = charStack.pop();
        if (ch != brackets.get(bracket)) {
          return false;
        }
      } else {
        charStack.push(bracket);
      }
    }
    return charStack.isEmpty();
  }
}
