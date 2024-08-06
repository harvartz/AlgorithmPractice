import java.util.*;
import java.io.*;

// 그래프와 트리의 차이점?
// 트리 순회는 다른 방법이 있었나?
// 1. wires를 양방향 그래프로 만든다.

class Solution {
    static int[][] map;
    static boolean[] visited;
    static int aCount;
    static int bCount;
    static int nodeSize;
    static int degreeSize;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        map = new int[n][n];
        nodeSize = n;
        degreeSize = wires.length;
                
        // 1. 양방향 그래프 만들기
        for(int i = 0; i< degreeSize ; i++){
            int aNode = wires[i][0] - 1;
            int bNode = wires[i][1] - 1;
            map[aNode][bNode] = 1;
            map[bNode][aNode] = 1;
        }

        // 2. DFS 순회 - 끊기고 나서도 순회를 해야하기 때문에 전체 반복문을 돌린다.
        // 연결을 한번씩 끊으면서 두 그래프가 비슷하게 나와야 한다.
        // 단, 끊었을 때 노드가 하나만 있으면 안된다. 트리는 부모 - 자식 간의 관계
        for(int i = 0; i < degreeSize; i++){
            // 두 노드의 연결이 끊겼을 때, 두 그래프를 count한다
            aCount = 0;
            visited = new boolean[nodeSize];

            int aNode = wires[i][0] - 1;
            int bNode = wires[i][1] - 1;
            System.out.println("aNode: " + aNode + ", bNode: " + bNode);
            
            map[aNode][bNode] = 0;
            map[bNode][aNode] = 0;
            
            dfs(0);
        
            answer = Math.min(answer, Math.abs(aCount - (n - aCount)));
            
            map[aNode][bNode] = 1;
            map[bNode][aNode] = 1;
        }
        return answer;
    }
    
    public void dfs(int start){
        visited[start] = true;
        aCount++;

        for(int i = 0; i < nodeSize; i++){
            if(!visited[i] && map[start][i] == 1){
                dfs(i);
            }
        }
    }
}