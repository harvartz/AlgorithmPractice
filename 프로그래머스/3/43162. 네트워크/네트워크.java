import java.util.*;
class Solution {
    static boolean [] m_visited;
    static int cnt = 0;
    static void DFS(int idx, int[][] computers)
    {
        if(m_visited[idx] == false)
        {
            m_visited[idx] = true;
            
            for(int i=0; i<computers[idx].length; i++)
            {
                if(i == idx)
                {
                    continue;
                }
                
                if(computers[idx][i] == 1)
                {
                    DFS(i, computers);
                }
                
                
            }
            
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        m_visited = new boolean[n];
        
        for(int i=0; i<computers.length; i++)
        {
            if(m_visited[i] == false)
            {
                DFS(i, computers);
                answer++;
            }
        }
        
        //System.out.println(answer);
        
        
        return answer;
    }
}