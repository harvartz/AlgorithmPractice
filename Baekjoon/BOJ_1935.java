import java.util.*;

public class Main {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();

      Stack<Double> stack = new Stack<Double>();
      String str = sc.next();

      double[] arr = new double[N];
      for(int x = 0; x<N; x++){
         arr[x] = sc.nextInt();
      }

      for(int y = 0; y< str.length() ; y++){
         if(str.charAt(y) >= 'A' && str.charAt(y) <= 'Z'){
            stack.push(arr[str.charAt(y) - 'A']);
         }
         else{
            if(!stack.isEmpty()){
               double first = stack.pop();
               double second = stack.pop();
               switch(str.charAt(y)){
                  case '*' :
                     stack.push(second * first);
                     continue;
                  case '+' :
                     stack.push(second + first);
                     continue;
                  case '-' :
                     stack.push(second - first);
                     continue;
                  case '/' :
                     stack.push(second / first);
                     continue;
                  case '%' :
                     stack.push(second % first);
                     continue;
               }
            }
         }
      }
      System.out.printf("%.2f", stack.pop());
   }
}
