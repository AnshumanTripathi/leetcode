package problems;

public class RotateImage {

  public static void main(String[] args) {
    int[][] image = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(image);
    printMatrix(image);
  }

  public static int[][] rotate(int[][] image) {
    int imageLength = image.length;
    for (int i = 0; i < imageLength; i++) {
      for (int j = i; j < imageLength; j++) {
        int temp = image[i][j];
        image[i][j] = image[j][i];
        image[j][i] = temp;
      }
    }
    for (int i = 0; i < imageLength; i++) {
      for (int j = 0; j < imageLength / 2; j++) {
        int temp = image[i][j];
        image[i][j] = image[i][imageLength - 1 - j];
        image[i][imageLength - 1 - j] = temp;
      }
    }
    return image;
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j ++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
