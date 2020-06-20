package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
  static final Map<Character, Character> brackets = new HashMap<>();
  public static void main(String[] args) {
    brackets.put(')', '(');
    brackets.put(']', '[');
    brackets.put('}', '{');
    System.out.println(isValid("()[]{}"));
    System.out.println(isValid("(]"));
    System.out.println(isValid("{[]}"));
    System.out.println(isValid("([)]"));
    System.out.println(isValid("()"));
  }
  public static boolean isValid(String s) {
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
