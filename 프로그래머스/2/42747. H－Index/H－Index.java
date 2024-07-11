import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        
        
        Arrays.sort(citations); // 정렬 해주기
        
        // 정렬 => [0, 1, 3, 5, 6]
        // 0번 이상 인용된 논문 갯수 : citations.length(=5)
        // 1번 이상 인용된 논문 갯수 : citations.length(=5) - 1 = 4
        // 3번 이상 인용된 논문 갯수 : citations.length(=5) - 2 = 3
        // 5번 이상 인용된 논문 갯수 : citations.length(=5) - 3 = 2
        // 6번 이상 인용된 논문 갯수 : citations.length(=5) - 4 = 1
        
        /*int max = 0;
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
        }*/
        
        for(int i=0; i<citations.length; i++)
        {
            int h = citations.length - i; // 논문 갯수
            if(citations[i] >= h)
            {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}