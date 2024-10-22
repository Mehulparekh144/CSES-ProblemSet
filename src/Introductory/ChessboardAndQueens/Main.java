package ChessboardAndQueens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    char[][] board = new char[8][8];

    for(int i = 0 ; i < 8 ; i++){
      board[i] = br.readLine().toCharArray();
    }

    boolean[] rows = new boolean[8];
    boolean[] tld = new boolean[16];
    boolean[] bld = new boolean[16];

    int[] count = new int[1];
    solve(0 , board , count , rows  , tld, bld);
    pw.println(count[0]);
    pw.close();
  }


  private static void solve(int col , char[][] board , int[] count , boolean[] rows                             , boolean[] tld , boolean[] bld ){
    if(col == 8){
      count[0]++;
      return;
    }

    for(int row = 0 ; row < 8 ; row++){
      if(board[row][col] != '*' && isSafe(board , row , col , rows , tld , bld)){
        board[row][col] = 'Q';

        rows[row] = true;
        tld[row + col] = true;
        bld[row - col + 8] = true;
        solve(col + 1 , board , count , rows  , tld , bld);

        rows[row] = false;
        tld[row + col] = false;
        bld[row - col + 8] = false;
        board[row][col] = '.';
      }
    }
  }

  private static boolean isSafe(char[][] board , int row , int col , boolean[] rows ,
                                boolean[] tld , boolean[] bld){
    return !rows[row] && !tld[row + col] && !bld[row - col + board.length];
  }
}
