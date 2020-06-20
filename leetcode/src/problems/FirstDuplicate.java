package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers where all the elements of the integers are smaller than the length,
 * find the first duplicate
 */
public class FirstDuplicate {

  public static void main(String[] args) {
    int[] array = new int[]{1,2,3,2,1};
    System.out.println("using brute force: " + bruteForce(array));
    System.out.println("Using Sets: " + usingSets(array));
    System.out.println("Space optimized: "+ spaceOptimized(array));
  }

  public static int bruteForce(int... array) {
    int first_duplicate = Integer.MAX_VALUE;
    for(int i = 0; i < array.length; i++) {
      for (int j = i+1; j < array.length; j++) {
        if (array[i] == array[j]) {
          first_duplicate = Math.min(first_duplicate, j);
        }
      }
    }
    if (first_duplicate != Integer.MAX_VALUE ) {
      return array[first_duplicate];
    }
    return -1;
  }

  public static int usingSets(int... array) {
    final Set<Integer> seen = new HashSet<>();
    for (final int num : array) {
      if (seen.contains(num)) {
        return num;
      }
      seen.add(num);
    }
    return -1;
  }

  public static int spaceOptimized(int... array) {
    for (int i = 0; i < array.length; i++) {
      int index = Math.abs(array[i] - 1);
      if (array[index] < 0) {
        return Math.abs(array[index]);
      } else {
        array[index] = array[index] * -1;
      }
    }
    return -1;
  }
}
