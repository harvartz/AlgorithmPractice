class Solution {
    int[][] graph;
    boolean[] visited;
    int aCount;

    public int solution(int n, int[][] wires) {
        graph = new int[n][n];
        int answer = Integer.MAX_VALUE;
        
        // 그래프 초기화
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0] - 1;
            int end = wires[i][1] - 1;
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        // 모든 간선을 하나씩 끊어서 시도
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0] - 1;
            int end = wires[i][1] - 1;
            graph[start][end] = 0;  // 간선을 끊음
            graph[end][start] = 0;

            visited = new boolean[n];
            aCount = 0;
            
            // 0번 노드부터 시작해서 탐색 (연결된 노드 개수 세기)
            dfs(0, n);
            int bCount = n - aCount; // 다른 그룹의 노드 개수
            
            // 두 그룹의 차이를 최소화
            answer = Math.min(answer, Math.abs(aCount - bCount));

            // 끊은 간선 복구
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        return answer;
    }

    // DFS로 연결된 노드 개수 세기
    public void dfs(int now, int n) {
        visited[now] = true;
        aCount++;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[now][i] == 1) {
                dfs(i, n);
            }            
        }
    }
}
