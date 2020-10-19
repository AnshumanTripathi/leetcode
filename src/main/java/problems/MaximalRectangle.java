package problems;

public class MaximalRectangle {


  public static void main(String[] args) {
    System.out.println(maximalRectangle(new char[][]{
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    }));
  }

  public static int maximalRectangle(char[][] matrix) {
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '1') {
          max = Math.max(max, findRectangle(i, j, matrix));
        }
      }
    }
    return max;
  }

  public static int findRectangle(int i, int j, char[][] matrix) {
    if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == '0') {
      return 0;
    }
    matrix[i][j] = '0';
    return 1 + findRectangle(i-1, j, matrix) +
    findRectangle(i+1, j, matrix) +
    findRectangle(i, j - 1, matrix) +
    findRectangle(i, j + 1, matrix);
  }
}
