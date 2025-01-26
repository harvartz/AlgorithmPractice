import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞음
        int answer = 0;
        while(!findAll(pq, K)){
            if(pq.size() == 1) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + second * 2;
            pq.offer(mixed);
            answer++;
        }
        return answer;
    }
    
    public static boolean findAll(PriorityQueue<Integer> pq, int K){
        
        for(int i : pq){
            if(i < K) {
                return false;
            }
        }
        return true;
    }
}