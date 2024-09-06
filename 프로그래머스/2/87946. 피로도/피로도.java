class Solution {
    boolean[] visited;
    int answer = Integer.MIN_VALUE;
    int count = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }
    
    public void dfs(int k, int depth, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                count++;
                visited[i] = true;
                k-= dungeons[i][1];
                answer = Math.max(count, answer);
                dfs(k, depth + 1, dungeons);
                visited[i] = false;
                k+= dungeons[i][1];
                count--;
            }
        }
    }
}