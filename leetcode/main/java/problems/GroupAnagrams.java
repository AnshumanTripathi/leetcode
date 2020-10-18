package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> result = groupAnagrams(input);
    for (List<String> list: result) {
      list.forEach(word -> System.out.print(word + " "));
      System.out.println();
    }
  }


  public static List<List<String>> groupAnagrams(String[] strs) {
    final List<List<String>> result = new ArrayList<>();
    if (strs.length == 0) {
      return result;
    }
    if (strs.length == 1) {
      result.add(Collections.singletonList(strs[0]));
      return result;
    }

    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String word : strs) {
      int[] alphabet = new int[26];
      for (char wordChar : word.toCharArray()) {
        alphabet[wordChar - 'a']++;
      }

      final StringBuilder builder = new StringBuilder();
      for (int count : alphabet) {
        builder.append(count);
      }

      String key = builder.toString();
      if (!anagramMap.containsKey(key)) {
        anagramMap.put(key, new ArrayList<>());
      }
      anagramMap.get(key).add(word);
    }

    result.addAll(anagramMap.values());

    return result;
  }
}
