package problems;

public class ReverseWords {

  public static void main(String[] args) {
//    System.out.println(reverseWords("Let's take LeetCode contest"));
    System.out.println(reverseSentence("a good   example"));
  }

  public static String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();
    String[] words = s.split(" ");
    for(String word : words) {
      StringBuilder wordSb = new StringBuilder(word);
      wordSb.reverse();
      sb.append(wordSb);
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  public static String reverseSentence(String s) {
    String[] words = s.split(" ");
    StringBuilder resultBuilder = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      if (!words[i].equals("")) {
        resultBuilder.append(words[i].trim());
        resultBuilder.append(" ");
      }
    }
    return resultBuilder.toString().trim();
  }
}
