class Solution {
    static boolean [] visited; // 방문처리 배열

	static void dfs(int idx, final int n, final int [][] computers)
	{
		// idx : 몇번째 컴퓨터인지
		// n : 컴퓨터 전체 개수
		// computers : 컴퓨터들의 연결 정보를 담고 있는 2차원 배열
		
		visited[idx] = true; // 방문 처리
		
		//for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(idx == j) // 자기 자신은 continue 처리
				{
					continue;
				}
				
				if(computers[idx][j] == 1)
				{
					if(visited[j] == false) // 연결되어있고, 아직 방문하지 않은 컴퓨터인 경우
					{
						dfs(j, n, computers); // dfs 함수 호출
					}
				}
			}
		}
	}
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
		
		for(int idx=0; idx<n; idx++)
		{
			if(visited[idx] == false)
			{
                answer++;
				dfs(idx,n,computers);
				
			}
		}
        
        return answer;
    }
}