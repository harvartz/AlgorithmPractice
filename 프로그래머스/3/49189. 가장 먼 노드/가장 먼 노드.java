import java.util.*;

class Solution {
    // 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지?
    // 1번 노드로부터 각 노드까지의 거리 = dfs의 깊이, bfs의 무엇?
    // 1번 노드로부터 각 노드까지의 최단 거리를 구하되, 
    // 메모리 초과가 뜨는데 어디를 확인해야 하지?
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] dist;
    public int solution(int n, int[][] edge) {
        // 초기화하기
        dist = new int[n];
        
        Arrays.fill(dist, -1);
        
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        // 그래프 그리기
        for(int i = 0; i < edge.length; i++){
            int startNode = edge[i][0] - 1;
            int endNode = edge[i][1] - 1;
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }
        
        bfs(0, n);
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(dist[i], max);
        }
        
        for(int i = 0; i < n; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int node, int n){
        dist[node] = 0;
        Deque<Integer> qu = new ArrayDeque<>();
        qu.offer(node);

        while(!qu.isEmpty()){
            int now = qu.poll();
            for(int i : graph.get(now)){
                if(dist[i] == -1){
                    dist[i] = dist[now] + 1;
                    qu.offer(i);
                }
            }
        }
    }
}