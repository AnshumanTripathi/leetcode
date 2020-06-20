package problems;

public class SearchInMatrix {

  public static void main(String[] args) {
    int[][] c = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    System.out.println(search(c, 3));
  }

  public static boolean search(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    int left = 0;
    int right = (rows * cols) - 1;

    int mid;
    int midValue;
    while ( left <= right) {
      mid = left + (right - left) / 2;
      midValue = matrix[mid / cols][mid % cols];
      if (midValue == target) {
        return true;
      } else if (midValue < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
