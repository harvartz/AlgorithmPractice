import javax.sound.midi.Patch;
import java.util.*;

public class 전화번호_목록 {
   public static void main(String []args){
      String[] input = {"119", "97674223", "1195524421"};

      HashMap<String, Integer> hashMap = new HashMap<>();

      for(String in : input){
         hashMap.put(in, 1);
      }

      System.out.println(hashMap);

      for(int x = 0; x<input.length; x++){
         for(int y = 0; y<input[x].length(); y++){
            System.out.println(input[x].substring(0,y));
            if(hashMap.containsKey(input[x].substring(0,y))){
               System.out.println(false);
            }else {
               System.out.println(true);
            }
         }
      }
   }
}