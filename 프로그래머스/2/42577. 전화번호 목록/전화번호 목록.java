import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++)
        {
            int ori_len = phone_book[i].length();
            int next_len = phone_book[i+1].length();
            
            if(ori_len <= next_len)
            {
                // 접두어인지 확인 필요.
                String tmp = phone_book[i+1].substring(0,ori_len);
                //System.out.println(tmp);
                
                if(phone_book[i].compareTo(tmp) == 0)
                {
                    //System.out.println("접두어 존재");
                    answer = false;
                    break;
                }
            }
            
        }
        
        
        
        return answer;
    }
}