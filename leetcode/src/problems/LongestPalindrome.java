package problems;

public class LongestPalindrome {

  public static void main(String[] args) {
    longestPalindrome("babad");
  }

  public static String longestPalindrome(String s) {
    int right = 1;
    String largestPalindrome = "";
    while (right != s.length()) {
      String currSting = "";
      for (int i = 0; i < right; i++) {
        currSting += s.charAt(i);
      }
      if (isPalindrome(currSting)) {
        if (largestPalindrome.length() < currSting.length()) {
          largestPalindrome = currSting;
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
