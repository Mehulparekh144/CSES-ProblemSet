package GrayCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n = Integer.parseInt(br.readLine());
//    int n = 3;

    List<String> grayCode = solve(n);
    for(String code : grayCode){
      pw.println(code);
    }

    pw.close();

  }

  private static List<String> solve(int N){
    if(N == 1){
      List<String> list = new ArrayList<>();
      list.add("1");
      list.add("0");
      return list;
    }

    List<String> prevCode = solve(N-1);
    List<String> reverse = new ArrayList<>(prevCode);
    Collections.reverse(reverse);

    List<String> curr = new ArrayList<>(prevCode);

    for(int i = 0 ; i < prevCode.size() ; i++){

      curr.set(i , "0" + reverse.get(i));
      prevCode.set(i , "1" + prevCode.get(i));
    }

    prevCode.addAll(curr);
    return prevCode;
  }
}
