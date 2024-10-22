package Permutations;

import java.util.Scanner;

public class Main {
  
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();

    if(n == 1){
      System.out.print(1);
    } else if(n == 2 || n == 3){
      System.out.print("NO SOLUTION");
    } else{
      StringBuilder sb = new StringBuilder();

      for(int i = 2 ; i <= n ; i+=2){
        sb.append(i + " ");
      }

      for(int i = 1 ; i <= n ; i+=2){
        sb.append(i + " ");
      }

      System.out.print(sb);
    }

    sc.close();
  }
}
