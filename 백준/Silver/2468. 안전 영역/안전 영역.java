import java.util.*;

public class Main {
	
	static int N; // 배열 W,H
	static int [][] map; // 안전영역 정보 담고 있는 2차원 배열
	static boolean [][] visit; // 방문 확인
	
	static int min = Integer.MAX_VALUE; //입력받는 수 중 제일 작은 수
	static int max = Integer.MIN_VALUE; //입력받는 수중 제일 큰 수
	
	static int [] di = {-1,1,0,0};
	static int [] dj = {0,0,-1,1};

	//static int res = 0;
	
	static void init_visit()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				visit[i][j]=false;
			}
		}
	}
	
	// dfs
	static void dfs(int condition, int i, int j)
	{
		visit[i][j] = true;
		
		//System.out.println(map[i][j]);
		
		for(int d=0; d<4; d++)
		{
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(ni >= 0 && ni <N && nj >=0 && nj <N)
			{
				if(visit[ni][nj] == false)
				{
					if(map[ni][nj] > condition)
					{
						dfs(condition,ni,nj);
					}
				}
			}
			
		}
		
	}
	
	static void bfs(int condition, int i, int j)
	{
		ArrayDeque<int []> q = new ArrayDeque<>();
		visit[i][j]=true;
		q.offer(new int[] {i,j});
		
		
		while(!q.isEmpty())
		{
			int [] cur = q.poll();
			
			i = cur[0];
			j = cur[1];
			
			for(int d=0; d<4; d++)
			{
				int ni = i+di[d];
				int nj = j+dj[d];
				
				if(ni >=0 && ni<N && nj >=0 && nj < N)
				{
					if(visit[ni][nj] == false)
					{
						if(map[ni][nj] > condition)
						{
							visit[ni][nj]=true;
							q.offer(new int[] {ni,nj});
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {

		// 입력받기
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				map[i][j] = sc.nextInt();
				
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		int count = 1; // 비가 오지 않았을 경우 
		{
			// 초기화 필요
			
			for(int condition = min; condition <= max; condition++)
			{
				int res_tmp = 0;
				init_visit();
				
				for(int i=0; i<N; i++)
				{
					for(int j=0; j<N; j++)
					{
						if(visit[i][j]== false)
						{
							if(map[i][j] > condition)
							{
								bfs(condition,i,j);
								res_tmp++;
							}
							
						}
					}
				}
				
				if(count < res_tmp)
				{
					count = res_tmp;
				}
				
			}
		}
		
		
		
		System.out.println(count);
		
		/*for(int dept=min+1; dept<max; dept++)
		{
			
				
			// 잠기는 영역을 min+1 ~ max-1 까지 바꿔가면서 확인
		}*/
	}

}
