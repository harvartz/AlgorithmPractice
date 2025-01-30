import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String x : phone_book){
            hashMap.put(x, 1);
        }
        
        // containsKey 활용하기
        for(int x = 0; x<phone_book.length; x++){
            for(int y = 1; y<phone_book[x].length(); y++){
                if(hashMap.containsKey(phone_book[x].substring(0,y))){
                    return false;
                }
            }
        }
        return true;
    }
}