import java.util.*;

public class Main {
   public static void main(String []args){
      
      int[] num = {3,3,2,4,5};

      int max = num.length/2;
      HashSet<Integer> numSet = new HashSet<>();

      for(int n : num){
         numSet.add(n);
      }

      if(numSet.size() > max){
         System.out.println(max);
      } else{
         System.out.println(numSet.size());
      }
   }
}