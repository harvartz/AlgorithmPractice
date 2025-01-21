class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0); // 초기값: level=0, sum=0
        return answer;
    }

    public void dfs(int[] numbers, int target, int level, int sum) {
        if (level == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 현재 level의 숫자를 더하거나 빼는 경우
        dfs(numbers, target, level + 1, sum + numbers[level]);
        dfs(numbers, target, level + 1, sum - numbers[level]);
    }
}
