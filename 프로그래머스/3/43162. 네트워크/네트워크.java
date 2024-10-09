import java.io.*;
import java.util.*;

class Solution {
    int count = 0;
    boolean[] visited; // 노드에 방문했는지 안했는지 확인하는 배열
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int start, int size, int[][] computers){
        for(int i = 0; i<size; i++){
            // 연결되어있는지 && 다음 탐색하려는 노드가 방문안했다면
            if(computers[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, size, computers);
            }
        }
    }
}