import java.util.*;
import java.io.*;

class Solution {
    int n = 0;
    int m = 0;
    int answer = 0;
    int[] dx = {-1, 0, 1,  0};
    int[] dy = {0 , 1, 0, -1};
    int[][] dist;
    Queue<int[]> qu = new LinkedList<>();
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        dist[0][0] = 1;
        qu.offer(new int[]{0,0});
        bfs(maps);
        
        if(dist[n-1][m-1] > 0){
            return dist[n-1][m-1];
        } else {
            return -1;
        }
    }
    
    public void bfs(int[][] maps){
        while(!qu.isEmpty()){
            int[] now = qu.poll();
            
            for(int i = 0; i<4; i++){
                int d_x = now[0] + dx[i];
                int d_y = now[1] + dy[i];
                
                if(0 <= d_x && d_x < n && 0 <= d_y && d_y < m){
                    if(dist[d_x][d_y] == 0 && maps[d_x][d_y] == 1){
                        dist[d_x][d_y] = dist[now[0]][now[1]] + 1;
                        qu.offer(new int[]{d_x, d_y});
                    } 
                }
            }
        }
    }
}