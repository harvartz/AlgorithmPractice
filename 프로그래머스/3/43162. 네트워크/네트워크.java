class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int count = 0;
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, n, computers);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int now, int size, int[][] computers){
        
        for(int i = 0; i < size; i++){
            if(computers[now][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i, size, computers);
            }
        }
    }
}