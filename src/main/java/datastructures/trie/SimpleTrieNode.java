package datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class SimpleTrieNode {
  char value;
  Map<Character, SimpleTrieNode> children = new HashMap<>();
  boolean end;

  public SimpleTrieNode() {
    end = false;
  }

  public SimpleTrieNode(char value) {
    this();
    this.value = value;
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }

  public Map<Character, SimpleTrieNode> getChildren() {
    return children;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }
}
