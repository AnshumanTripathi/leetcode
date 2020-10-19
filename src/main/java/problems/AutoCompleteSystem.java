package problems;

import java.util.ArrayList;
import java.util.List;

class AutocompleteSystem {

  final MyTrie trie = new MyTrie();
  String curr = "";

  public AutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      trie.add(sentences[i], times[i]);
    }
  }

  public List<String> input(char c) {
    List<String> returnList = new ArrayList<>();
    if (c == '#') {
      trie.add(curr);
      curr = "";
    } else {
      curr += c;
      final List<Results> mapping = trie.getAutoComplete(curr);
      mapping.sort((r1, r2) -> {
        int diff = r2.getTimes() - r1.getTimes();
        if (diff == 0) {
          return r1.getResult().compareTo(r2.getResult());
        }
        return diff;
      });


      for (int i = 0; i < Math.min(3, mapping.size()); i++) {
        returnList.add(i, mapping.get(i).getResult());
      }
    }
    return returnList;
  }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
class MyTrie {
  TrieNode root;

  public MyTrie() {
    this.root = new TrieNode();
  }

  private int getIndex(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  public void add(String value) {
    add(value, null, null);
  }

  public void add(String value, int times) {
    add(value, times, null);
  }

  public void add(String value, Integer times, TrieNode node) {
    TrieNode currentNode = node == null ? root : node;

    for (char c : value.toCharArray()) {
      int index = getIndex(c);
      if (currentNode.getChildren()[index] == null) {
        TrieNode temp = new TrieNode(c);
        currentNode.getChildren()[index] = temp;
        currentNode = temp;
      } else {
        currentNode = currentNode.getChildren()[index];
      }
    }
    currentNode.setEnd(true);
    if (times == null) {
      currentNode.setTimes(currentNode.getTimes() + 1);
    } else {
      currentNode.setTimes(currentNode.getTimes() + times);
    }
  }

  public List<Results> getAutoComplete(final String input) {
    TrieNode temp = root;
    List<Results> words = new ArrayList<>();
    for (char c : input.toCharArray()) {
      int index = getIndex(c);
      if (temp.getChildren()[index] == null) {
        return words;
      }
      temp = temp.getChildren()[index];
    }

    if (temp.getTimes() != 0) {
      words.add(new Results(input, temp.getTimes()));
    }
    for (TrieNode node : temp.getChildren()) {
      if (node != null) {
        traverse(words, node, input);
      }
    }
    return words;
  }

  private void traverse(List<Results> result, TrieNode node, String word) {
    word = word + node.getValue();
    if (node.isEnd()) {
      result.add(new Results(word, node.getTimes()));
    }

    for (int i = 0; i < node.getChildren().length; i++) {
      if (node.getChildren()[i] != null) {
        traverse(result, node.getChildren()[i], word);
      }
    }
  }
}


class TrieNode {
  char value;
  TrieNode[] children = new TrieNode[27];
  boolean end;
  int times;

  public int getTimes() {
    return times;
  }

  public void setTimes(int times) {
    this.times = times;
  }

  public TrieNode() {
    this.end = false;
  }

  public TrieNode(char value) {
    this();
    this.value = value;
  }

  public TrieNode[] getChildren() {
    return children;
  }

  public char getValue() {
    return value;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }
}

class Results {
  private String result;
  private int times;

  public Results(String result, int times) {
    this.result = result;
    this.times = times;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public int getTimes() {
    return times;
  }
}
