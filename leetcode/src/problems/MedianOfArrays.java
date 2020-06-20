package problems;

import java.util.Arrays;

public class MedianOfArrays {
  public static void main(String[] args) {
    System.out.println(median(new int[]{1, 3}, new int[]{2, 4}));
  }

  public static double median(int[] nums1, int[] nums2) {
    int[] resultArray = new int[nums1.length + nums2.length];
    int lengthCounter = 0;
    for (int i = 0; i < nums1.length; i++) {
      resultArray[i] = nums1[i];
      lengthCounter++;
    }
    for (int value : nums2) {
      resultArray[lengthCounter] = value;
      lengthCounter++;
    }
    Arrays.sort(resultArray);
    int med1 = resultArray[resultArray.length / 2];
    if (resultArray.length % 2 == 0) {
      int med2 = resultArray[resultArray.length / 2 - 1];
      return (double) (med1 + med2) / 2;
    }
    return med1;
  }
}
