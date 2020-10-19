package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class KDiffPairs {

  public int findPairs(int[] nums, int k) {
    if (k < 0) {
      return 0;
    }
    if (nums.length <= 1) {
      return 0;
    }
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int num : nums) {
      numMap.put(num, numMap.getOrDefault(num, 0) + 1);
    }

    int pairs = 0;
    for (int num : nums) {
      if (numMap.containsKey(num)) {
        if (k == 0) {
          if (numMap.get(num) > 1) {
            pairs++;
          }
        } else {
          if (numMap.containsKey(num - k)) {
            pairs++;
          }
          if (numMap.containsKey(num + k)) {
            pairs++;
          }
        }
        numMap.remove(num);
//        if (numMap.get(num) > 1) {
//          numMap.put(num, numMap.get(num) - 1);
//        } else {
//          numMap.remove(num);
//        }
      }
    }
    return pairs;
  }

  /**
   * Can be done using sets, but its not clean to handle k = 0 use case
   */
  public static int myPairs(int[] nums, int k) {
    if (k < 0) {
      return 0;
    }
    if (nums.length <= 1) {
      return 0;
    }

    Set<Integer> numSet = new HashSet<>();
    for (int num: nums) {
      numSet.add(num);
    }

    int pairs = 0;
    for (int num: nums) {
      if (numSet.contains(num)) {
        if (k == 0) {
          if (numSet.contains(num)) {
            pairs++;
          }
        }
        if (numSet.contains(num - k)) {
          pairs++;
        }
        if (numSet.contains(num + k)) {
          pairs++;
        }
      }
      numSet.remove(num);
    }
    return pairs;
  }
}
