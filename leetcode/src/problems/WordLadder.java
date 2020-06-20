package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

  //  beginWord = "hit",
//  endWord = "cog",
//  wordList = ["hot","dot","dog","lot","log","cog"]
//  Output = 5
//  "hit" -> "hot" -> "dot" -> "dog" -> "cog"
//  hit -> hot -> dot, lot -> dog -> cog

//  "ymain"
//  "oecij"
//["ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"]

  public static void main(String[] args) {
//    System.out.println(ladderLength("hit", "cog",
//        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    System.out.println(ladderLength("ymain", "oecij",
        Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain")));
    System.out.println(ladderLengthNew("ymain", "oecij",
        Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain")));
//    System.out.println(ladderLengthNew("hit", "cog",
//        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//    System.out.println(ladderLength("a", "c",
//        Arrays.asList("a", "b", "c")));
  }


  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (wordList.isEmpty()) {
      return 0;
    }
    if (beginWord.equals(endWord)) {
      return 0;
    }
    final Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    final Queue<String> queue = new LinkedList<>();
    int transformations = 1;
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        char[] currentWord = queue.poll().toCharArray();
        for (int j = 0; j < currentWord.length; j++) {
          char originalChar = currentWord[j];
          for (char k = 'a'; k <= 'z'; k++) {
            currentWord[j] = k;
            String tempWord = String.valueOf(currentWord);
            if (tempWord.equals(endWord)) {
              return transformations + 1;
            }
            if (wordSet.contains(tempWord)) {
              queue.offer(tempWord);
              wordSet.remove(tempWord);
            }
          }
          currentWord[j] = originalChar;
        }
      }
      transformations++;
    }
    return 0;
  }

  public static int ladderLengthNew(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    // COUNT NUMBER OF WORDS TRANSFORMED
    int count = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      // FOR ALL WORDS THIS ROUND
      for (int i = 0; i < size; i++) {
        char[] current = queue.poll().toCharArray();
        // TRAVERSE CURRENT WORD
        for (int j = 0; j < current.length; j++) {
          char tmp = current[j];
          // CHANGE ONE LETTER AT A TIME
          for (char c = 'a'; c <= 'z'; c++) {
            current[j] = c;
            String next = new String(current);
            // WHEN NEXT WORD IS IN THE SET
            if (set.contains(next)) {
              if (next.equals(endWord)) return count + 1;
              queue.add(next);
              set.remove(next);
            }
          }
          // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
          current[j] = tmp;
        }
      }
      // THIS ROUND ENDS WITH ONE LETTER CHANGED
      count++;
    }
    return 0;
  }
}
