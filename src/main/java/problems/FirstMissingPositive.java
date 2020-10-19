package problems;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

  public static void main(String[] args) {
    System.out.println(firstMissingPositive(new int[]{1,2,0}));
    System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    System.out.println(firstMissingPositive(new int[]{0, 1, 2}));

    System.out.println(findFast(new int[]{1,2,0}));
    System.out.println(findFast(new int[]{3,4,-1,1}));
    System.out.println(findFast(new int[]{7,8,9,11,12}));
    System.out.println(findFast(new int[]{0, 1, 2}));
  }

  public static int firstMissingPositive(int[] nums) {
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

  public static int findFast(int[] nums) {
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
