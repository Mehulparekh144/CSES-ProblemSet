package AppleDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n = Integer.parseInt(br.readLine());
    String[] split = br.readLine().split(" ");
    long[] arr = new long[n];

    for(int i = 0 ; i < split.length ; i++){
      arr[i] = Long.parseLong(split[i]);
    }

    long sum = Arrays.stream(arr).sum();
    long minDiff = Long.MAX_VALUE;

    for(int i = 0 ; i < (1 << n) ; i++){
      long subSetSum = 0;

      for(int j = 0 ; j < n ; j++){
        if((i & (1 << j)) != 0){
          subSetSum += arr[j];
        }
      }

      minDiff = Math.min(minDiff ,Math.abs(subSetSum -  sum + subSetSum) );
    }

    pw.println(minDiff);

    pw.close();
  }
}
