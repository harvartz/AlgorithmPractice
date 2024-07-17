import java.util.*;

class Solution {
     public String solution(String[] participant, String[] completion) 
	{
		String answer = "";
        
        Map <String, Integer> map_info = new HashMap<>(); // 이름, 이름에 해당하는 사람 수...
        
        // 참가자 정보 저장
        for(int i=0; i<participant.length; i++)
        {
            if(map_info.containsKey(participant[i]) == true)
            {
                // 해당 이름으로 등록된 사람이 있는 경우 - 기존에 등록된 사람 수 + 1로 정보 갱신
            	map_info.replace(participant[i] , map_info.get(participant[i])+1);
            }
            else
            {
                // 없는 경우 - 추가 (이름, 1)
            	map_info.put(participant[i], 1);
            }
        }
        
        // 완주한 사람들의 이름과 참가자 이름 비교 후 계산
        for(int i=0; i<completion.length; i++)
        {
            if(map_info.containsKey(completion[i]) == true)
            {
                int value = map_info.get(completion[i]);
                if(value == 1)
                {
                	map_info.remove(completion[i]);
                }
                else
                {
                	map_info.replace(completion[i], value-1);
                }
            }
        }
        
        // map에 남아 있는 사람의 이름이 완주하지 못한 사람의 이름
        for(String key : map_info.keySet())
        {
            answer = key;
        }
        
        return answer;
	}
}