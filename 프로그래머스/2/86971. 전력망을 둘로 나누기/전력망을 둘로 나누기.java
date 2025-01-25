import java.util.*;
import java.io.*;

class Solution {
    boolean[] visited;
    int[][] graph;
    int count = 0;
    int answer = Integer.MAX_VALUE;
    int size;
    
    public int solution(int n, int[][] wires) {
        size = n;
        visited = new boolean[n];
        graph = new int[n][n];
        
        for(int i = 0; i < wires.length; i++){
            for(int j = 0; j < 2; j++){
                int aNode = wires[i][0] - 1;
                int bNode = wires[i][1] - 1;
                
                graph[aNode][bNode] = 1;
                graph[bNode][aNode] = 1;
            }
        }
        
        for(int i = 0; i < wires.length; i++){
            int aNode = wires[i][0] - 1;
            int bNode = wires[i][1] - 1;
            graph[aNode][bNode] = 0;
            graph[bNode][aNode] = 0;
            System.out.println("aNode: " + aNode + ", bNode:" + bNode);
            
            // 0번 노드부터 시작
            dfs(0);
            
            // 순회하기 - 하나의 그래프만 구하면 전체에서 빼면 된다.
            int a = Math.abs((n-count) - count);
            answer = Math.min(a, answer);
            
            count = 0;
            visited = new boolean[n];
            graph[aNode][bNode] = 1;
            graph[bNode][aNode] = 1;
        }
        
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
    
    public void dfs(int nowNode){
        visited[nowNode] = true;
        count++;
        
        for(int j = 0; j < size; j++){
            if(!visited[j] && graph[nowNode][j] == 1){
                dfs(j);
            }
        }
    }
}