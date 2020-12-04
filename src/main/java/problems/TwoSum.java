package problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> numTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numTable.containsKey(target - nums[i])) {
                return new int[]{i, numTable.get(target - nums[i])};
            } else {
                numTable.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
