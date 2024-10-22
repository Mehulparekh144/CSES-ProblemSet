package GridPaths;
import java.io.*;
import java.util.Arrays;

public class Main {
  static int[][][] dp = new int[49][7][7]; // Memoization table

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    String path = br.readLine();
    for (int[][] grid : dp) {
      for (int[] row : grid) {
        Arrays.fill(row, -1); // Initialize memo table with -1
      }
    }

    pw.println(solve(0, path, 0, 0));
    pw.flush();
  }

  private static int solve(int idx, String path, int i, int j) {
    if (i < 0 || j < 0 || i >= 7 || j >= 7) {
      return 0;
    }

    if (i == 6 && j == 6) {
      if (idx == path.length()) return 1;
      else return 0;
    }

    if (idx >= path.length()) return 0;

    if (dp[idx][i][j] != -1) return dp[idx][i][j]; // Use memoized result

    char ch = path.charAt(idx);
    int result = 0;

    if (ch == '?') {
      result += solve(idx + 1, path, i + 1, j); // Move Down
      result += solve(idx + 1, path, i - 1, j); // Move Up
      result += solve(idx + 1, path, i, j + 1); // Move Right
      result += solve(idx + 1, path, i, j - 1); // Move Left
    } else {
      if (ch == 'D') {
        result += solve(idx + 1, path, i + 1, j);
      } else if (ch == 'R') {
        result += solve(idx + 1, path, i, j + 1);
      } else if (ch == 'L') {
        result += solve(idx + 1, path, i, j - 1);
      } else if (ch == 'U') {
        result += solve(idx + 1, path, i - 1, j);
      }
    }

    dp[idx][i][j] = result; // Memoize result
    return result;
  }
}
