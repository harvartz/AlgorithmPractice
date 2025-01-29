import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();

        for(int x = 0; x< progresses.length; x++){
            queue.add((int)(Math.ceil((100.0-progresses[x])/speeds[x])));
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }
        return answer;
    }
}
