package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
  private static final String INPUT = "aaabbbcddd";

  public static void main(String[] args) {
    System.out.println("Using Brute force: " + bruteForce(INPUT));
    System.out.println("Using Maps: " + usingMaps(INPUT));
    System.out.println("Using Char arrays: " + usingCharArray(INPUT));
    System.out.println("Using IndexOf: " + usingIndexOf(INPUT));
  }

  private static char bruteForce(final String input) {
    for (int i = 0; i < input.length(); i++) {
      boolean seen = false;
      for (int j = 0; j < input.length(); j++) {
        if (input.charAt(i) == input.charAt(j) && i != j) {
          seen = true;
          break;
        }
      }
      if (!seen) return input.charAt(i);
    }
    return '_';
  }

  private static char usingMaps(final String input) {
    final Map<Character, Integer> lookupMap = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
      if (lookupMap.containsKey(input.charAt(i))) {
        int counter = lookupMap.get(input.charAt(i));
        lookupMap.put(input.charAt(i), ++counter);
      } else {
        lookupMap.put(input.charAt(i), 1);
      }
    }
    for (int i = 0; i < input.length(); i++) {
      if (lookupMap.get(input.charAt(i)) == 1) {
        return input.charAt(i);
      }
    }
    return '_';
  }

  private static char usingCharArray(final String input) {
    int[] alphabet = new int[26];
    for (char c : input.toCharArray()) {
      alphabet[c - 'a']++;
    }
    for (char c : input.toCharArray()) {
      if (alphabet[c - 'a'] == 1) {
        return c;
      }
    }
    return '_';
  }

  private static char usingIndexOf(final String input) {
    for (int i = 0; i < input.length(); i++) {
      if (input.indexOf(input.charAt(i)) == input.lastIndexOf(input.charAt(i))) {
        return input.charAt(i);
      }
    }
    return '_';
  }
}
