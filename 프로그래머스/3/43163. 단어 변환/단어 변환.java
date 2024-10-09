class Solution {
    int answer = 0;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String word, String target, String[] words, int depth){
        // 만약 바꾼 단어가 target과 일치하다? 그러면 바로 return
        if(word.equals(target)) {
            answer = depth;
            return;
        }
        
        
        for(int i = 0; i < words.length; i++){
            
            if(visited[i]) continue;
            if(isPossible(word, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }            
    }
    
    public boolean isPossible(String now, String compare){
        int count = 0;
        for(int i = 0; i<now.length(); i++){
            if(now.charAt(i) != compare.charAt(i)){
                count++;
            }
        }
        if(count == 1) return true;
        else return false;
    }
}