package datastructures.trie;

public class WordSearch {
  SimpleTrieNode root;

  public WordSearch() {
    root = new SimpleTrieNode();
  }

  public void addWord(String word) {
    SimpleTrieNode currentNode = root;
    for(char ch : word.toCharArray()) {
      SimpleTrieNode child = currentNode.getChildren().get(ch);
      if (child == null) {
        SimpleTrieNode temp = new SimpleTrieNode(ch);
        currentNode.getChildren().put(ch, temp);
        currentNode = temp;
      } else {
        currentNode = currentNode.getChildren().get(ch);
      }
    }
    currentNode.setEnd(true);
  }

  public boolean search(String word) {
    return search(word, 0, root);
  }

  public boolean search(String word, int index, SimpleTrieNode node) {
    if (index == word.length()) {
      return node.isEnd();
    }
    char ch = word.charAt(index);
    if (ch == '.') {
      for (SimpleTrieNode childNode : node.getChildren().values()) {
        if (search(word, index + 1, childNode)) {
          return true;
        }
      }
    } else {
      if (node.getChildren().containsKey(ch)) {
        return search(word, index+1, node.getChildren().get(ch));
      }
    }
    return false;
  }

  public static void main(String[] args) {
    WordSearch obj = new WordSearch();
    obj.addWord("bad");
    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");
    System.out.println(obj.search("pad"));
    System.out.println(obj.search("bad"));
    System.out.println(obj.search(".ad"));
    System.out.println(obj.search("b.."));

  }
}
