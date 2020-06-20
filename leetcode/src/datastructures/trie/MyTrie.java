package datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class MyTrie {

  TrieNode root;

  public MyTrie() {
    this.root = new TrieNode();
  }

  private int getIndex(char c) {
    return c == ' ' ? 26 : c - 'a';
  }

  public void addPrefixed(String prefix) {
    TrieNode temp = root;
    for (char c : prefix.toCharArray()) {
      int index = getIndex(c);
      if (temp.getChildren()[index] != null) {
        temp = temp.getChildren()[index];
      }
    }
    add(prefix, temp.getTimes(), temp);
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

  public boolean search(String value) {
    TrieNode current = root;
    for (char c : value.toCharArray()) {
      int index = getIndex(c);
      TrieNode node = current.getChildren()[index];
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current != root;
  }

  public List<Results> traverse() {
    final List<Results> result = new ArrayList<>();
    for (int i = 0; i < root.getChildren().length; i++) {
      if (root.getChildren()[i] != null) {
        traverse(result, root.getChildren()[i], "");
      }
    }
    return result;
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
      words.add(new Results(input, temp.times));
    }
    for (TrieNode node : temp.getChildren()) {
      if (node != null) {
        traverse(words, node, input);
      }
    }
    return words;
  }

  private String getAutoComplete(StringBuilder builder, TrieNode temp) {
    if (temp.getValue() != Character.MIN_VALUE) {
      builder.append(temp.getValue());
    }
    if (temp.isEnd()) {
      return builder.toString();
    }
    for (int i = 0; i < temp.getChildren().length; i++) {
      if (temp.getChildren()[i] != null) {
        getAutoComplete(builder, temp.children[i]);
      }
    }
    return "";
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

    public void setTimes(int times) {
      this.times = times;
    }
  }

  public static void main(String[] args) {
    MyTrie trie = new MyTrie();
    trie.add("island", 1);
    trie.add("iceland", 3);
    trie.add("anshuman", 3);

//    System.out.println(trie.search("island"));
//    trie.traverse().forEach((str, times) -> System.out.println(str + " , " + times));
    trie.getAutoComplete("is")
        .forEach((result) -> System.out.println(result.getResult() + ", " + result.getTimes()));
  }
}
