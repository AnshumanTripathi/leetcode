package datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class AutocompleteSystem {
  final MyTrie trie = new MyTrie();
  String curr = "";

  public AutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      trie.add(sentences[i], times[i]);
    }
  }

  public List<String> input(char c) {
    if (c == '#') {
      trie.add(curr);
      curr = "";
    } else {
      curr += String.valueOf(c);
      trie.add(curr);
    }

    final List<MyTrie.Results> mapping = trie.getAutoComplete(curr);
    mapping.sort((r1, r2) -> {
      int diff = r2.getTimes() - r1.getTimes();
      if (diff == 0) {
        return r1.getResult().compareTo(r2.getResult());
      }
      return diff;
    });

    List<String> returnList = new ArrayList<>();
    for (int i = 0; i < mapping.size(); i++) {
      if (i == 3) {
        break;
      }
      returnList.add(i, mapping.get(i).getResult());
    }
    return returnList;
  }

  public static void main(String[] args) {
    AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
        new String[]{"i love you", "island","ironman", "i love leetcode"},
        new int[]{5,3,2,2});
    autocompleteSystem.input('i').forEach(System.out::println);
    System.out.println();
    autocompleteSystem.input(' ').forEach(System.out::println);
    System.out.println();
    autocompleteSystem.input('a').forEach(System.out::println);
    System.out.println();
    autocompleteSystem.input('#').forEach(System.out::println);
    System.out.println();
  }
}
