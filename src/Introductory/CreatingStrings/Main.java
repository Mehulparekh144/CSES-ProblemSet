package CreatingStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    String str = br.readLine();

    Set<String> strs = new TreeSet<>();
    Set<String> set = new HashSet<>();


    solve(str , set , strs , new StringBuilder());
    pw.println(strs.size());
    for(String s : strs){
      pw.println(s);
    }

    pw.close();
  }

  private static void solve(String str , Set<String> set , Set<String> strs ,
                            StringBuilder sb){
    if(sb.length() == str.length() ){
      strs.add(sb.toString());
      return;
    }

    for(int j = 0 ; j < str.length() ; j++){
      String key = j + "#" + str.charAt(j);

      if(!set.contains(key)){
        sb.append(str.charAt(j));
        set.add(key);
        solve(str , set , strs , sb);
        set.remove(key);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
