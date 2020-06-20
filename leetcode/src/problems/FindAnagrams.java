package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAnagrams {

  public static void main(String[] args) {
//    findAnagramsOptimized("cbaebabacd", "abc").forEach(System.out::println);
//    findAnagramsArray("cbaebabacd", "abc").forEach(System.out::println);
//    System.out.println();
//    findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa").forEach(System.out::println);
    System.out.println(isValidAnagram("anagram", "nagaram"));
    System.out.println(isValidAnagram("cat", "rat"));
  }

  public static List<Integer> findAnagramsArray(String s, String p) {
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

  public static List<Integer> findAnagramsOptimized(String s, String p) {
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

  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> indices = new ArrayList<>();
    if (s.length() <= p.length()) {
      return indices;
    }
    Set<String> anagramsSet = new HashSet<>();
    findAnagrams("", p, anagramsSet);
    for (String candidate : anagramsSet) {
      int start = 0;
      int end = p.length();
      while(end <= s.length()) {
        if(s.substring(start, end).equals(candidate)) {
          indices.add(start);
        }
        start++;
        end = start + p.length();
      }
    }
    return indices;
  }

  public static void findAnagrams(String prefix, String input, Set<String> anagrams) {
    if (input.length() == 0) {
      anagrams.add(prefix);
      return;
    }
    for (int i = 0; i < input.length(); i++) {
      findAnagrams(prefix + input.charAt(i), input.substring(0, i) +
          input.substring(i+1), anagrams);
    }
  }

  public static boolean isValidAnagram(String s, String t) {
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
}