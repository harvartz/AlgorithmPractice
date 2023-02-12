import java.util.*;

public class Main {
   public static void main(String args[]) {
       Stack<Integer> stack = new Stack<Integer>();
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

       for(int x = 0; x<N; x++){
           int M = sc.nextInt();
           if (M == 0) {
               stack.pop();
           }
           else{
               stack.push(M);
           }
       }
       int sum = 0;

       for(int o : stack){
           sum += o;
       }

       System.out.println(sum);
   }
}
