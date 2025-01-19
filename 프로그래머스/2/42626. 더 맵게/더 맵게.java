import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int answer = 0;
        
        for(int x = 0; x<scoville.length; x++){
            que.add(scoville[x]);
        }
        
        while(que.peek() < K){
            if(que.size()==1){
                return -1;
            }
            que.add(que.poll() + que.poll()*2);
            answer++;
        }
        
        return answer;
    }
}