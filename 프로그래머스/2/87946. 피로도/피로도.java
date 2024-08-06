import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int size;
    static int result;
    static int answer = 0;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        size = dungeons.length;
        result = 0;
        recur(0, k, dungeons);
        
        //System.out.println("End Recur: " + max);
        return max;
    }
    
    public void recur(int level, int now, int[][] dungeons){
        // if(level == size){
        //     System.out.println("=======size full");
        //     return;
        // }
        for(int i = 0; i<size; i++){
            // 최소 필요 피로도 < 소모 필요도
            if(dungeons[i][0] <= now && !visited[i]){
                result++;
                visited[i] = true;
                now -= dungeons[i][1];
                //System.out.println("now: " + now);
                //System.out.println("result: "+ result );
                
                max = Math.max(max, result);
                //System.out.println("Max result: " + result );
                
                recur(level + 1, now, dungeons);
                now += dungeons[i][1];
                visited[i] = false;
                result--;
            }
        }
    }
}