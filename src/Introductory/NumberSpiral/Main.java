
package NumberSpiral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String[] input = br.readLine().split(" ");
      long x = Long.parseLong(input[0]);
      long y = Long.parseLong(input[1]);
      long ans;
      if (y > x) {
        if (y % 2 != 0) {
          ans = y * y - x + 1;
        } else {
          ans = ((y - 1) * (y - 1)) + x;
        }
      } else {
        if (x % 2 != 0) {
          ans = ((x - 1) * (x - 1)) + y;
        } else {
          ans = x * x - y + 1;
        }
      }
      pw.println(ans);
      t--;
    }
    pw.flush();
    pw.close();
  }
}
