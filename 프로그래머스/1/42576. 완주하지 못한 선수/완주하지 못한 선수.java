import java.util.*;

class Solution {
     public String solution(String[] participant, String[] completion) 
	{
		String answer = "";
        
        Map <String, Integer> m_map = new HashMap<>(); // 이름, 이름에 해당하는 사람 수...
        
        // 참가자 정보 저장
        for(int i=0; i<participant.length; i++)
        {
            if(m_map.containsKey(participant[i]) == true)
            {
                // 해당 이름으로 등록된 사람이 있는 경우 - 기존에 등록된 사람 수 + 1로 정보 갱신
                int value = m_map.get(participant[i]);
                m_map.replace(participant[i] , value+1);
            }
            else
            {
                // 없는 경우
                m_map.put(participant[i], 1);
            }
        }
        
        // 완주자 이름과 참가자 이름 비교 후 계산
        for(int i=0; i<completion.length; i++)
        {
            if(m_map.containsKey(completion[i]) == true)
            {
                int value = m_map.get(completion[i]);
                if(value == 1)
                {
                    m_map.remove(completion[i]);
                }
                else
                {
                    m_map.replace(completion[i], value-1);
                }
            }
        }
        
        for(String key : m_map.keySet())
        {
            answer = key;
        }
        
        return answer;
	}
}