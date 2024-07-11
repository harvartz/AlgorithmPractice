import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        // 0, 1, 3, 5, 6
        //answer = citations.length;
        
        int max = 0;
        for(int i=0; i<citations.length; i++)
        {
            if(citations[i] >= (citations.length-i))
            {
                if(max < citations.length-i)
                {
                    max = citations.length-i;
                    System.out.println(citations[i]+"/"+(citations.length-i));
                }
            }
        }
        
        if(max != 0)
        {
            answer = max;
        }
        
        return answer;
    }
}