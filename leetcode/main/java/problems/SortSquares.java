package problems;

import java.util.Arrays;

/**
 * Problem Statement:
 * Given a sorted array of integers, return a sorted array of squares of the given array.
 */

public class SortSquares {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortSquaresBruteForce(new int[]{-6, 1, 2, 3})));
    System.out.println(Arrays.toString(sortSquaresOptimized(new int[]{-6, 1, 2, 3})));
  }

  private static int[] sortSquaresBruteForce(final int[] input) {
    for (int i = 0; i < input.length; i++) {
      input[i] = input[i] * input[i];
    }
    Arrays.sort(input);
    return input;
  }

  private static int[] sortSquaresOptimized(final int[] input) {
    int[] output = new int[input.length];
    int left = 0;
    int right = input.length - 1;
    for (int i = 0; i < input.length; i++) {
      int leftSquare = input[left] * input[left];
      int rightSquare = input[right] * input[right];

      if (leftSquare > rightSquare) {
        output[output.length -1 -i] = leftSquare;
        left++;
      } else {
        output[output.length -1 -i] = rightSquare;
        right--;
      }
    }
    return output;
  }
}
