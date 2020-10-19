package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {

  public List<Integer> findAnagramsArray(String s, String p) {
    final List<Integer> indices = new ArrayList<>();
    if (p.length() >= s.length()) {
      return indices;
    }

    char[] pCharArray = new char[26];
    for (char pChar : p.toCharArray()) {
      pCharArray[pChar - 'a']++;
    }

    char[] sCharArray = new char[26];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int index = ch - 'a';
      sCharArray[index]++;
      if (i >= p.length()) {
        ch = s.charAt(i - p.length());
        index = ch - 'a';
        if(sCharArray[index] == 1) {
          sCharArray[index] = 0;
        } else {
          sCharArray[index]--;
        }
      }

      if (Arrays.equals(sCharArray, pCharArray)) {
        indices.add(i - p.length() + 1);
      }
    }

    return indices;
  }

  public List<Integer> findAnagramsOptimized(String s, String p) {
    final List<Integer> indices = new ArrayList<>();
    if (p.length() >= s.length()) {
      return indices;
    }

    Map<Character, Integer> pMap = new HashMap<>();
    for (char pChar : p.toCharArray()) {
      if (!pMap.containsKey(pChar)) {
        pMap.put(pChar, 0);
      }
      int pCount = pMap.get(pChar);
      pMap.put(pChar, ++pCount);
    }

    Map<Character, Integer> sMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!sMap.containsKey(ch)) {
        sMap.put(ch, 0);
      }
      int sCount = sMap.get(ch);
      sMap.put(ch, ++sCount);
      if (i >= p.length()) {
        ch = s.charAt(i - p.length());
        if (sMap.get(ch) == 1) {
          sMap.remove(ch);
        } else {
          sMap.put(ch, sMap.get(ch) - 1);
        }
      }

      if (pMap.equals(sMap)) {
        indices.add(i - p.length() + 1);
      }
    }
    return indices;
  }


  public boolean isValidAnagram(String s, String t) {
    if (t.length() < s.length() || t.length() > s.length()) {
      return false;
    }
    int[] sArray = new int[26];
    int[] tArray = new int[26];

    for (char sChar: s.toCharArray()) {
      sArray[sChar -'a']++;
    }

    for (char tChar : t.toCharArray()) {
      tArray[tChar - 'a']++;
    }
    return Arrays.equals(sArray, tArray);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
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

//  https://leetcode.com/problems/find-anagram-mappings/
  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Integer> aMap = new HashMap<>();

    for (int i = 0; i < B.length; i++) {
      aMap.put(B[i], i);
    }

    int[] result = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      result[i] = aMap.get(A[i]);
    }

    return result;
  }
}