class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = count;
        return count;
    }
    
    public void dfs(int[] numbers, int level, int target, int result){
        if(level == numbers.length){
            if(target == result){
                count++;
            }
            return;
        }
        int plus = result + numbers[level];
        int minus = result - numbers[level];
        
        dfs(numbers, level+1, target, plus);
        dfs(numbers, level+1, target, minus);
    }
}