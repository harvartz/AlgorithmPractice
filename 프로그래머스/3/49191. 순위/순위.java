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
        // 해당 알고리즘의 각 경로를 경유할 때마다 값을 비교하여 최솟값으로 갱신해준다의 초점이 맞춰져 있다.
        // 'a 가 b 이기고 b가 c를 이기면 a는 반드시 c를 이긴다' 라는 로직을 적용함
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                for(int z = 0; z <= n; z++){
                    // j가 i를 이기고 i가 z를 이긴다면 j는 z를 이길 수 밖에 없다.
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
                // i가 j를 이기거나 j가 i를 이겼다면 순위를 정할 수 있다는 것
                if(graph[i][j] == 1 || graph[j][i] == 1){
                    game++;
                }
            }
            // game = n-1이라면 이 게임은 모든 다른 선수와 승패 관계가 있다는 뜻
            // 우리는 해당 선수의 전체에서 몇순위인지 확인할 수 있는 선수임을 알아야 함.
            // 즉, 이 선수가 자신을 제외한 나머지 사람들과 모든 승패를 알 수 있어야 한다.
            if(game == n-1){
                answer++;
            }
        }
        return answer;
    }
}