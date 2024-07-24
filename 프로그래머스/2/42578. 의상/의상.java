import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> map= new HashMap<>();
        for(String[] clothe : clothes){
            String type = clothe[1];
             map.put(type,map.getOrDefault(type,0)+1);
        }
        int answer =1;
        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        amswer -=1;
        return answer;
    }
}