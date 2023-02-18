import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      LinkedList<Integer> deque = new LinkedList<Integer>();

      int count = 0;

      int N = sc.nextInt();
      int M = sc.nextInt();

      for(int i = 1; i <= N; i++){
         deque.offer(i);
      }

      int[] arr = new int[N];
      for(int i = 0; i<M; i++ ){
         arr[i] = sc.nextInt();
      }


      for(int i = 0; i< M; i++){

         int target_idx = deque.indexOf(arr[i]);
         int half_idx;

            if(deque.size() % 2 == 0){
               half_idx = deque.size() / 2 - 1;
            }else{
               half_idx = deque.size() / 2;
            }


         if(target_idx <= half_idx){

            for(int j = 0; j<target_idx; j++){
               int temp = deque.pollFirst();
               deque.offerLast(temp);
               count++;
            }
         }
         else{

            for(int j = 0; j < deque.size() - target_idx; j++){
               int temp = deque.pollLast();
               deque.offerFirst(temp);
               count++;
            }
         }
         deque.pollFirst();
      }
      System.out.println(count);
   }
}