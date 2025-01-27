import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] result = new String[numbers.length];
        
        for(int x=0; x<numbers.length;x++){
            result[x] = String.valueOf(numbers[x]);
        }
        
        // 여기가 핵심.
        // 두 수를 합쳤을 때(문자열 합치기) 
        // compareTo() 함수
        Arrays.sort(result, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        
        if(result[0].equals("0")){
            return "0";   
        }
        
        String answer = "";
        for(String a : result){
            answer += a;
        }
        return answer;
    }
}