import javax.sound.midi.Patch;
import java.util.*;

public class 완주하지_못한_선수 {
   public static void main(String []args){
      String[] participant = {"leo", "kiki", "eden"};
      String[] completion = {"eden", "kiki"};

      String answer = "";

      HashMap<String, Integer> hashMap = new HashMap<>();

      for(String p : participant){
         hashMap.put(p, hashMap.getOrDefault(p,0)+1);
      }

      for(String c : completion){
         hashMap.put(c, hashMap.get(c)-1);
      }

      for(String r : hashMap.keySet()){
         if(hashMap.get(r) != 0){
            answer = r;
         }
      }

      System.out.println(answer);
   }
}