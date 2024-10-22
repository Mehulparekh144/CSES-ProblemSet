package PalindromeReorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

  private static String solve(String str){
    int[] freq = new int[26];

    for(char c : str.toCharArray()){
      freq[c - 'A']++;
    }

    int cnt = 0;
    for(int i = 0 ; i < 26 ; i++){
      if(freq[i]%2 != 0){
        cnt++;
      }
    }

    if(cnt > 1) {
      return "NO SOLUTION";
    }

    int left = 0 , right = str.length() - 1;
    char[] arr = new char[str.length()];

    for(int i = 0 ; i < 26 ; i++){
      while(freq[i] > 1){
        arr[left++] = (char) ('A' + i);
        arr[right--] = (char) ('A' + i);
        freq[i] -= 2;
      }
    }

    for(int i = 0 ;i < 26 ; i++){
      if(freq[i] == 1){
        arr[str.length()/2] = (char)( 'A' + i);
        break;
      }
    }

    return new String(arr);


  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    String str = br.readLine();
    System.out.println(solve(str));

    pw.close();

  }
}
