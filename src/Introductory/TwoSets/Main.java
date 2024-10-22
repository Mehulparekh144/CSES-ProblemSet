import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    
    int n = Integer.parseInt(br.readLine());

    long sum = (long) n * (n + 1) / 2;
    if(sum%2 != 0){
      System.out.println("NO");
    } else{
      System.out.println("YES");
      Set<Long> numbers = new HashSet<>();
      Set<Long> numbers2 = new HashSet<>();
      
      long target = sum/2;
      long curr = 0;

      for(long i = n ; i >= 1 ; i--){
        if(curr + i <= target){
          numbers.add(i);
          curr += i;
        } else{
          numbers2.add(i);
        }
      }

      pw.println(numbers.size());
      for(long num : numbers){
        pw.print(num + " ");
      }
      pw.println(numbers2.size());
      for(long num : numbers2){
        pw.print(num + " ");
      }
    }

    pw.close();
  }
}