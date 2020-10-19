package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: Given an array of integers, find the maximum sum of a contiguous subarray
 */

public class SubArrayMaxSum {

  public static void main(String[] args) {
//    System.out.println(subsets(new int[]{1,2,3}).toString());
    System.out.println(subArraysMaxSum(new int[]{1,2}));
    System.out.println(subArraysMaxSum(new int[]{1}));
    System.out.println(subArraysMaxSum(new int[]{0}));
    System.out.println(subArraysMaxSum(new int[]{-1}));
  }

  private static int subArraysMaxSum(int[] input) {
//    if (input.length == 1) {
//      return input[0];
//    }
    int maxSum = input[0];
    int currentSum = maxSum;

    for (int i = 1; i < input.length; i++) {
      currentSum = Math.max(currentSum + input[i], input[i]);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList();
    backTrack(result, new ArrayList(), nums, 0);
    return result;
  }

  static void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int current) {

    if (!result.contains(temp)) result.add (new ArrayList(temp));

    for (int i = current; i < nums.length; i++) {
      temp.add(nums[i]);
      backTrack(result, temp, nums, i+1);
      temp.remove(temp.size()-1);
    }
  }
}
