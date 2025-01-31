import java.util.*;
import java.io.*;


class Solution {

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