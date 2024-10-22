package TwoKnights;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n = Integer.parseInt(br.readLine());

    for (long i = 1; i <= n; i++) {
      long totalWaysToPlace = (long) ((i * i) * ((i * i) - 1)) / 2;

      // 4: Each knight's L-shaped move leads to 4 pairs of positions where they can
      // attack each other.
      // (n - 1): This term represents the rows the first knight can occupy (excluding
      // the last row since it wouldn’t allow for a knight to jump).
      // (n - 2): This term represents the columns the second knight can occupy after
      // the first knight is placed.
      long rectangles = (long) 4 * (i - 1) * (i - 2);

      long ans = totalWaysToPlace - rectangles;
      pw.println(ans);
    }

    pw.flush();
    pw.close();
  }
}
