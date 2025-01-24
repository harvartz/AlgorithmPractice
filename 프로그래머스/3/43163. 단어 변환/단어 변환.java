class Solution {
    
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(answer == Integer.MAX_VALUE){
            return 0;
        }
        return answer;
    }
    
    public void dfs(String now, String target, String[] words, int level){
        
        if(now.equals(target)){
            answer = Math.min(level, answer);
        }
        
        for(int i = 0; i < words.length; i++){
            boolean isChange = false;
            int sameChar = 0;

            for(int j = 0; j < target.length(); j++){
                if(now.charAt(j) != words[i].charAt(j)){
                    sameChar += 1;
                }
            }
            
            if(sameChar == 1 && !visited[i]) {
                isChange = true;
                // System.out.println(words[i]);
            }else{
                isChange = false;
            }
            
            if(!visited[i] && isChange){
                visited[i] = true;
                dfs(words[i], target, words, level + 1);
                visited[i] = false;
            }
        }
    }
}