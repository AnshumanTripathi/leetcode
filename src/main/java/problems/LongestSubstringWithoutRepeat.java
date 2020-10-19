package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }

  public static int lengthOfLongestSubstring(String s) {
    final Set<Character> characterSet = new HashSet<>();
    int i = 0, j = 0;
    int largestString = 0;
    while (i < s.length() && j< s.length()) {
      if (!characterSet.contains(s.charAt(j))) {
        characterSet.add(s.charAt(j));
        j++;
        largestString = Math.max(largestString, j-i);
      } else {
        characterSet.remove(s.charAt(i));
        i++;
      }
    }
    return largestString;
  }
}
