package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsInPhoneNumbers {
  final static Map<String, String> numberCombinations = new HashMap<>();
  final static List<String> output = new ArrayList<>();

  public static void main(String[] args) {
//    System.out.println(letterCombinations("23"));
    System.out.println(letterCombinations(""));
  }

  public static List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return output;
    }
    createMap();
    getCombos("", digits);
    return output;
  }

  public static void getCombos(String digits, String next) {
    if (next.length() == 0) {
      output.add(digits);
    } else {
      String digit = next.substring(0,1);
      String letters = numberCombinations.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = String.valueOf(numberCombinations.get(digit).charAt(i));
        getCombos(digits + letter, next.substring(1));
      }
    }
  }

  public static void createMap() {
    numberCombinations.put("2", "abc");
    numberCombinations.put("3", "def");
    numberCombinations.put("4", "ghi");
    numberCombinations.put("5", "jkl");
    numberCombinations.put("6", "mno");
    numberCombinations.put("7", "pqrs");
    numberCombinations.put("8", "tuv");
    numberCombinations.put("9", "wxyz");
  }
}
