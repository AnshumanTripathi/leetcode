package datastructures.trie;

public class TrieNode {
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

  public void setChildren(TrieNode[] children) {
    this.children = children;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }

}
