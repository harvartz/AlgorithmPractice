import java.util.*;

class Solution {

    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    int[] dist;
    public int solution(int n, int[][] edge) {
        dist = new int[n];
        
        Arrays.fill(dist, -1);
        
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
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