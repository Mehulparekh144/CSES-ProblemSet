package TrailingZeroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    long n = Long.parseLong(br.readLine());

    pw.println(solve(n));
    pw.close();
  }

  private static long solve(long n){
    if(n == 0) return 0;
    return n/5 + solve(n/5);
  }
  
}
