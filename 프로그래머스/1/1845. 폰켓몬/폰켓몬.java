import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int max = nums.length/2;
        //System.out.println(max);
        
        Set<Integer> m_set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
        {
            m_set.add(nums[i]);
        }
        
        if(m_set.size() > max)
        {
            answer = max;
        }
        else
        {
            answer = m_set.size();
        }
        
        
        
        return answer;
    }
}