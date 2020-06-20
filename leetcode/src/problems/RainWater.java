package problems;

public class RainWater {

  public static void main(String[] args) {
    System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trap(new int[]{0,2,0}));
    System.out.println(trap(new int[]{2,0,2}));

    System.out.println(trapDynamic(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trapDynamic(new int[]{0,2,0}));
    System.out.println(trapDynamic(new int[]{2,0,2}));

    System.out.println(trapPointers(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    System.out.println(trapPointers(new int[]{0,2,0}));
    System.out.println(trapPointers(new int[]{2,0,2}));

  }

  public static int trap(int[] height) {
    int total = 0;
    int lMax;
    int rMax;
    for (int i = 0; i < height.length - 1; i++) {
      lMax = height[i];
      rMax = height[i];
      for (int j = 0; j < i; j++) {
        lMax = Math.max(lMax, height[j]);
      }
      for (int j = i+1; j < height.length; j++) {
        rMax = Math.max(rMax, height[j]);
      }
      total += Math.min(lMax, rMax) - height[i];
    }
    return Math.max(total, 0);
  }

  public static int trapDynamic(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int total = 0;
    int[] left = new int[height.length];
    int[] right = new int[height.length];

    left[0] = height[0];
    right[height.length - 1] = height[height.length - 1];

    for (int i = 1; i < height.length; i++) {
      left[i] = Math.max(left[i-1], height[i]);
    }

    for (int i = height.length - 2; i >= 0; i--) {
      right[i] = Math.max(right[i+1], height[i]);
    }

    for (int i = 0; i < height.length; i++) {
      total += Math.min(left[i], right[i]) - height[i];
    }

    return total;
  }

  public static int trapPointers(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int total = 0;
    int left = 0;
    int right = height.length - 1;
    int lMax = 0;
    int rMax = 0;

    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] > lMax) {
          lMax = height[left];
        } else {
          total += lMax - height[left];
        }
        left++;
      } else {
        if (height[right] > rMax) {
          rMax = height[right];
        } else {
          total += rMax - height[right];
        }
        right--;
      }
    }
    return total;
  }
}
