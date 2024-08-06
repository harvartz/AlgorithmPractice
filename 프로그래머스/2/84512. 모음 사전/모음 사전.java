import java.io.*;
import java.util.*;


class Solution {
    static List<String> list = new LinkedList<>();
    static char[] w = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    public int solution(String word) {
        dfs(0, "");
        for(String find : list){
            if(find.equals(word)){
                answer = list.indexOf(find);
            }
        }
        return answer;
    }
    
    public void dfs(int level, String str){
        list.add(str);
        if(level == 5){
            return;
        }
        
        for(int i = 0; i<5; i++){
            dfs(level + 1, str + w[i]);
        }
    }
}