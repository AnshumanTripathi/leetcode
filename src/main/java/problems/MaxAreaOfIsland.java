package problems;

// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, findRectangle(i, j, grid));
        }
      }
    }
    return max;
  }

  private int findRectangle(int i, int j, int[][] matrix) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0) {
      return 0;
    }
    matrix[i][j] = 0;
    return 1 + findRectangle(i - 1, j, matrix) +
        findRectangle(i + 1, j, matrix) +
        findRectangle(i, j - 1, matrix) +
        findRectangle(i, j + 1, matrix);
  }
}
