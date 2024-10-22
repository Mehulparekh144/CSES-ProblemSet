package CoinPiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
  private static final Map<String, Boolean> memo = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    long tests = Long.parseLong(br.readLine());

    while (tests-- > 0) {
      String[] nums = br.readLine().split(" ");
      long a = Long.parseLong(nums[0]);
      long b = Long.parseLong(nums[1]);

      if (solve(a, b)) {
        pw.println("YES");
      } else {
        pw.println("NO");
      }
    }

    pw.close();
  }

  private static boolean solve(long a, long b) {

    // 1*x + 2*y = a // Remove x times 1 coin or remove y times 2 coin will give a
    // 2*x + 1*y = b // Vice versa

    // simplify equations
    // y = (2a-b)/3
    // x = (2b-a)/3

    return ((2 * a - b) >= 0) && ((2 * b - a) >= 0) && ((2 * a - b) % 3 == 0) && ((2 * b - a) % 3 == 0);

  }

  // private static boolean solve(long a, long b) {
  // String key = a + "," + b;

  // if (memo.containsKey(key)) {
  // return memo.get(key);
  // }

  // if (a == 0 && b == 0) {
  // return true;
  // }
  // if (a <= 0 || b <= 0) {
  // return false;
  // }

  // boolean result = solve(a - 2, b - 1) || solve(a - 1, b - 2);

  // memo.put(key, result);

  // return result;
  // }
}
