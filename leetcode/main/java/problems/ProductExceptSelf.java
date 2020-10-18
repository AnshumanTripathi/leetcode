package problems;

import java.util.Arrays;

public class ProductExceptSelf {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(product(new int[]{1,2,3,4})));
    System.out.println(Arrays.toString(spaceOptimizedProduct(new int[]{1,2,3,4})));
  }

  public static int[] product(int[] input) {
    int[] output = new int[input.length];
    int[] left = new int[input.length];
    int[] right = new int[input.length];

    left[0] = 1;
    right[input.length - 1] = 1;

    for (int i = 1; i < input.length; i++) {
      left[i] = input[i - 1] * left[i - 1];
    }

    for (int i = input.length - 2; i >= 0; i--) {
      right[i] = input[i + 1] * right[i + 1];
    }

    for(int i = 0; i < input.length; i++) {
      output[i] = left[i] * right[i];
    }

    return output;
  }

  public static int[] spaceOptimizedProduct(int [] input) {
    int[] output = new int[input.length];
    output[0] = 1;

    for (int i = 1; i < input.length; i++) {
      output[i] = output[i - 1] * input[i - 1];
    }

    int right = 1;
    for (int i = input.length - 1; i >= 0; i--) {
      output[i] = output[i] * right;
      right *= input[i];
    }

    return output;
  }
}
