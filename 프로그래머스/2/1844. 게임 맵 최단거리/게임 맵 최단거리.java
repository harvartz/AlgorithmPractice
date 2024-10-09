import java.util.*;

class Solution {
    int n;
    int m;
    int count = 0;
    int[][] dist;
    Queue<int[]> qu = new LinkedList<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        // 1. 변수 초기 세팅
        n = maps.length;
        m = maps[0].length;
        System.out.println("n: " + n +", m:" + m);
        dist = new int[n][m];
        
        dfs(0, 0, maps);
        
        // for(int x = 0; x<n; x++){
        //     for(int y = 0; y<m; y++){
        //         System.out.print(dist[x][y] + "  ");
        //     }
        //     System.out.println();
        // }
        
        if(dist[n-1][m-1] == 0) return -1;
        int answer = dist[n-1][m-1];
        return answer;
    }
    
    public void dfs(int x, int y, int[][] maps){
        dist[x][y] = 1;
        qu.offer(new int[]{x, y});
        
        while(!qu.isEmpty()){
            int[] now = qu.poll();
            for(int i = 0; i < 4; i++){
                int d_x = now[0] + dx[i];
                int d_y = now[1] + dy[i];
                
                if(0 <= d_x && d_x < n && 0 <= d_y && d_y < m){
                    if(dist[d_x][d_y] == 0 && maps[d_x][d_y] == 1){
                        dist[d_x][d_y] = dist[now[0]][now[1]] + 1;
                        if(d_x == n-1 && d_y == m-1 ) {
                            return;
                        }
                        int[] in = new int[]{d_x, d_y};
                        qu.offer(in);
                    }
                }
            }
        }
        
        
   }
}