package problems;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    int contains = 0;
    for (int num : nums) {
      if (num == 1) {
        contains++;
        break;
      }
    }

    if (contains == 0) {
      return 1;
    }

    if (nums.length == 1) {
      return 2;
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0 || nums[i] > nums.length) {
        nums[i] = 1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);
      if (index == nums.length) {
        nums[0] = -index;
      } else {
        nums[index] = -Math.abs(nums[index]);
      }
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        return i;
      }
    }
    if (nums[0] > 0) {
      return nums.length;
    }

    return nums.length + 1;
  }

  public int findFast(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    for (int i=1; i<=nums.length; i++) {
      if (!numSet.contains(i)) {
        return i;
      }
    }
    return numSet.size() + 1;
  }
}
