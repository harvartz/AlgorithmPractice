import java.util.*;
import java.io.*;

// int[] 형식의 정렬 방법

class Solution {
    // 1. 우선 순위 큐
    // 2. 큐
    // 3. 스택? -> 대신 큐와 같은 순서를 지키기 힘들다.
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< priorities.length; i++){
            qu.add(priorities[i]);
        }
        int answer = 0;
        
        while(!qu.isEmpty()){
            for(int i = 0; i<priorities.length; i++){
                if(qu.peek() == priorities[i]){
                    qu.poll();
                    answer++;
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}