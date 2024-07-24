class Solution {
    static int N = 0;
	static int C = 0;
	
	static void subs(int cnt, int res, int [] numbers, int target)
	{
		if(cnt == N) // 종료조건
		{
			if(res == target)
			{
				C++;
			}
			
			return;
		}
		
		// 더한 경우
		subs(cnt+1, res+numbers[cnt], numbers, target);
		
		// 뺀 경우
		subs(cnt+1, res-numbers[cnt], numbers, target);
	}
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
		N = numbers.length;
        subs(0,0,numbers,target);
        
        answer = C;
        
        return answer;
    }
}