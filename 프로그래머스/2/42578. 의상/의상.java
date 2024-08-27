import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
         
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(int i = 0; i<clothes.length; i++){
                // 1번은 의상의 종류, 0번은 의상의 이름
                hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Iterator<Integer> it = hashMap.values().iterator();
        int answer = 1;
        while(it.hasNext()){
            answer *= it.next().intValue() + 1;
        }
        
        return answer - 1;
    }
}