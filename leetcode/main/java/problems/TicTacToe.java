package problems;

import java.util.Arrays;

public class TicTacToe {

  private int[][] board;
  private int size;

  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    this.board = new int[n][n];
    this.size = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
//  public int moveBrute(int row, int col, int player) {
//    board[row][col] = chars[player - 1];
//    char[] winArray = new char[size];
//    if (player == 1) {
//      for (int i = 0; i < size; i++) {
//        winArray[i] = 'X';
//      }
//    } else {
//      for (int i = 0; i < size; i++) {
//        winArray[i] = 'O';
//      }
//    }
//    int startRow = 0;
//    while(startRow < size) {
//      char[] rows = new char[size];
//      for (int i = 0; i < size; i++) {
//        rows[i] = board[startRow][i];
//      }
//      if (Arrays.equals(winArray, rows)) {
//        return player;
//      }
//      startRow++;
//    }
//    int startCol = 0;
//    while (startCol < size) {
//      char[] cols = new char[size];
//      for (int i = 0; i < size; i++) {
//        cols[i] = board[i][startCol];
//      }
//      if (Arrays.equals(winArray, cols)) {
//        return player;
//      }
//      startCol++;
//    }
//
//
//    char[] diagonal = new char[size];
//    for (int i = 0, j = 0; i < size && j < size; i++, j++) {
//      diagonal[i] = board[i][j];
//      if (Arrays.equals(diagonal, winArray)) {
//        return player;
//      }
//    }
//    diagonal = new char[size];
//    for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
//      diagonal[i] = board[i][j];
//      if (Arrays.equals(diagonal, winArray)) {
//        return player;
//      }
//    }
//    return 0;
//  }

  public int move(int row, int col, int player)  {
    board[row][col] = player;
    boolean win = true;
    for (int i = 0; i < size; i++) {
      if (board[row][i] != player) {
        win = false;
        break;
      }
    }

    if (win) {
      return player;
    }

    win = true;
    for (int i = 0; i < size; i++) {
      if (board[i][col] != player) {
        win = false;
        break;
      }
    }

    if (win) {
      return player;
    }

    win = true;
    for (int i = 0; i < size; i++) {
      if (board[i][i] != player) {
        win = false;
        break;
      }
    }

    if (win) {
      return player;
    }

    win = true;
    for (int i = 0; i < size; i++) {
      if (board[i][size - 1 - i] != player) {
        win = false;
        break;
      }
    }

    return win ? player : 0;
  }

  public static void main(String[] args) {
    TicTacToe toe = new TicTacToe(3);
//    System.out.println(toe.move(0, 0, 1));
//    System.out.println(toe.move(0, 2, 2));
//    System.out.println(toe.move(2, 2, 1));
//    System.out.println(toe.move(1, 1, 2));
//    System.out.println(toe.move(2, 0, 1));
//    System.out.println(toe.move(1, 0, 2));
//    System.out.println(toe.move(2, 1, 1));

//    toe = new TicTacToe(2);
//    System.out.println(toe.move(0,0, 2));
//    System.out.println(toe.move(1,1, 1));
//    System.out.println(toe.move(0,1, 2));
//
//    toe = new TicTacToe(2);
//    System.out.println(toe.move(0,1, 1));
//    System.out.println(toe.move(1,1, 2));
//    System.out.println(toe.move(1,0, 1));

    toe = new TicTacToe(3);
    System.out.println(toe.move(0,0,2));
    System.out.println(toe.move(2,0,2));
    System.out.println(toe.move(1,0,2));
  }
}
