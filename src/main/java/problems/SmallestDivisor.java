package problems;

public class SmallestDivisor {

  public static void main(String[] args) {
    System.out.println(smallestDivisor(new int[]{1,2,5,9}, 6));
    System.out.println(smallestDivisor(new int[]{19}, 5));
    System.out.println(smallestDivisor(new int[]{2,3,5,7,11}, 11));
    System.out.println(smallestDivisor(new int[]{962551,933661,905225,923035,990560}, 10));

    System.out.println(findSmallest(new int[]{1,2,5,9}, 6));
    System.out.println(findSmallest(new int[]{19}, 5));
    System.out.println(findSmallest(new int[]{2,3,5,7,11}, 11));
    System.out.println(findSmallest(new int[]{962551,933661,905225,923035,990560}, 10));
  }

  public static int smallestDivisor(int[] nums, int threshold) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    if (max == 1) {
      return max;
    }
    return findDivisor(nums, 0, max, threshold);
  }

  public static int findDivisor(int[] nums, int left, int right, int threshold) {
    int mid = left + (right - left) / 2;
    if (left == right) {
      return right;
    }
    if (mid == 0) {
      return right;
    }

    int total = 0;
    for (int num : nums) {
      int div = num / mid;
      if (num % mid != 0) {
        div++;
      }
      total += div;
    }

    if (total <= threshold) {
      return findDivisor(nums, left, mid, threshold);
    } else {
      return findDivisor(nums, mid+1, right, threshold);
    }
  }

  public static int findSmallest(int[] nums, int threshold) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        max = num;
      }
    }
    if (max == 1) {
      return max;
    }

    int minSum = Integer.MAX_VALUE;
    int result = 1;
    for (int i=1; i < max; i++) {
      int total = 0;
      for (int num : nums) {
        int div = num / i;
        if (num % i != 0) {
          div++;
        }
        total += div;
      }
      if (total < minSum) {
        minSum = total;
        if (minSum <= threshold) {
          result = i;
          break;
        }
      }
    }
    return result;
  }
}
