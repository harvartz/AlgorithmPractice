class Solution {  
    int answer = 0;  
  
    public int solution(int[] numbers, int target) {  
        dfs(0, numbers, target, 0);  
        return answer; 
    }  
  
    private void dfs(int depth, int[] numbers, int target, int sum) {  
        // 모든 숫자를 다 사용한 경우
        if (depth == numbers.length) {  
            // 현재까지의 합이 target과 같다면 경우의 수 증가
            if (sum == target) {  
                answer++;  
            }  
            return;  // 탐색 종료
        }  
        
        // 현재 숫자를 더하는 경우
        dfs(depth + 1, numbers, target, sum + numbers[depth]);  
        // 현재 숫자를 빼는 경우
        dfs(depth + 1, numbers, target, sum - numbers[depth]);  
    }  
}
