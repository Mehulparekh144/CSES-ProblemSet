package SortingAndSearching.DistinctNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    long n = Long.parseLong(br.readLine());
    String[] split = br.readLine().split(" ");
    Set<Long> nums = new HashSet<>();

    for(String num : split){
      nums.add(Long.parseLong(num));
    }

    pw.println(nums.size());
    pw.close();
  }
}