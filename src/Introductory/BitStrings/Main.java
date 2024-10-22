package BitStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
  private static final int MOD = (int) 1e9 + 7;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    long n = Long.parseLong(br.readLine());

    long ans = power(2 , n);

    pw.println(ans);

    pw.close();

  }

  private static long power(long base , long expo ){
    long ans = 1;

    while(expo > 0){
      if(expo%2 != 0){
        ans = (ans * base)%MOD;
      }

      base = (base * base)%MOD;
      expo /= 2;
    }

    return ans;
  }
}
