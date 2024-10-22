package TowerOfHanoi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int n = Integer.parseInt(bufferedReader.readLine());

    List<String>  list = new ArrayList<>();
    solve(n , 1 , 3 , 2 , list);
    int k = list.size();

    pw.println(k);
    for(String s : list){
      pw.println(s);
    }

    pw.close();
  }

  private static void solve(int n , int A , int C , int B , List<String> list){
    if(n == 1){
      list.add(A + " " + C);
      return;
    }

    // Move n-1 from A -> B
    solve(n-1 , A , B , C , list);
    list.add(A + " " + C);
    // Move n-1 from B -> C
    solve(n-1 , B , C , A , list);
  }
}
