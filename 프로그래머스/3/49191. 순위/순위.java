class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        int answer = 0;
        
        // 그래프 초기화
        for(int i = 0; i < results.length; i++){
            int winner = results[i][0];
            int losser = results[i][1];
            graph[winner][losser] = 1;
        }
        
        // 플로이드 워샬 알고리즘 이용
        // 플로이드 워샬은 각 노드에서 모든 노드로 갈 수 있는 최단 거리를 구할 수 있는 알고리즘
        // 해당 노드에서 모든 노드로 이동할 때 
        // 'a 가 b 이기고 b가 c를 이기면 a는 반드시 c를 이긴다' 라는 로직을 적용함
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                for(int z = 0; z <= n; z++){
                    if(graph[j][i] == 1 && graph[i][z] == 1){
                        // i는 반드시 z를 이길 수 있으니 1로 넣어준 것
                        graph[j][z] = 1;
                    }
                }
            }
        }
        
        // 순위를 매길 수 있는 게임을 확인하는 반복문
        for(int i = 1; i <= n; i++){
            // 각 선수의 승패 정보를 담은 변수
            int game = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] == 1 || graph[j][i] == 1){
                    game++;
                }
            }
            // game = n-1이라면 이 게임은 모든 다른 선수와 승패 관계가 있다는 뜻
            if(game == n-1){
                answer++;
            }
        }
        return answer;
    }
}