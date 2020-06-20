package problems;

public class RepeatedSubstringPattern {

  public static void main(String[] args) {
    System.out.println(repeatedSubstringPattern("abab"));
    System.out.println(repeatedSubstringPattern("aba"));
    System.out.println(repeatedSubstringPattern("bb"));
  }

  public static boolean repeatedSubstringPattern(String s) {
    String newString = s + s;
    return newString.substring(1, newString.length() - 1).contains(s);
  }
}
