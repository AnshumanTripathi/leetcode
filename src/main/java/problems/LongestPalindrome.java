package problems;

public class LongestPalindrome {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("cbbd"));
  }

  public static String longestPalindrome(String s) {
    int right = 1;
    String largestPalindrome = "";
    while (right != s.length()) {
      StringBuilder currSting = new StringBuilder();
      for (int i = 0; i < right; i++) {
        currSting.append(s.charAt(i));
      }
      if (isPalindrome(currSting.toString())) {
        if (largestPalindrome.length() < currSting.length()) {
          largestPalindrome = currSting.toString();
        }
      }
      right++;
    }
    return largestPalindrome;
  }

  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
