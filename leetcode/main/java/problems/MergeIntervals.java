package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public static void main(String[] args) {
//    int[][] result = merge(new int[][]{{2,6}, {1,3}, {8,10}, {15,18}});
    int[][] result = merge(new int[][]{{1,4}, {4,5}});
    for(int i = 0; i < result.length - 1; i++) {
      System.out.print("["+result[i][0]+","+result[i][1]+"]" + ", ");
    }
    System.out.print("["+result[result.length - 1][0]+","+result[result.length - 1][1]+"]\n");
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
      return intervals;
    }

    Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

    List<int[]> result = new ArrayList<>();
    int[] currentInterval = intervals[0];
    result.add(currentInterval);
    for (int i = 1; i < intervals.length; i++) {
      if (currentInterval[1] >= intervals[i][0]) {
        currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
      } else {
        currentInterval = intervals[i];
        result.add(currentInterval);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
