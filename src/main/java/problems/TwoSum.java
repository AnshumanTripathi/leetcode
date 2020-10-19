package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15,3,8,16}, 19)));
  }

  public static int[] twoSum(int[] nums, int target) {
    final Map<Integer, Integer> numTable = new HashMap<>();
    for (int i=0; i<nums.length; i++) {
      if (numTable.containsKey(target - nums[i])) {
        return new int[]{i, numTable.get(target - nums[i])};
      } else {
        numTable.put(nums[i], i);
      }
    }
    return new int[]{};
  }
}
