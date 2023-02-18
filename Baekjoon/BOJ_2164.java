import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      Deque<Integer> q = new LinkedList<>();

      for(int x=1; x<=N; x++){
         q.offer(x);
      }

      while(q.size() != 1){

         q.poll();

         int item = q.peek();
         q.poll();
         q.offer(item);
      }
      System.out.println(q.peek());
   }
}