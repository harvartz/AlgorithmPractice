import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        Map <String, Integer> m_map = new HashMap<>(); // 이름, 사람 수...
        
        // 참가자 정보 저장
        for(int i=0; i<participant.length; i++)
        {
            if(m_map.containsKey(participant[i]) == true)
            {
                // 키가 이미 있는 경우
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
            System.out.println(key);
        }
        
        System.out.println(m_map.size());
        
        
        
        
        
        
        // 동명이인 체크...
        
        /*ArrayList <String> participant_list = new ArrayList<>();
        for(int i=0; i<participant.length; i++)
        {
            participant_list.add(participant[i]);
        }
        
        ArrayList <String> completion_list = new ArrayList<>();
        for(int i=0; i<completion.length; i++)
        {
            completion_list.add(completion[i]);
        }*/
        
        /*Iterator <String> iter1 = completion_list.iterator();
        while(iter1.hasNext())
        {
            String name = iter1.next();
            int idx = participant_list.indexOf(name);
            //System.out.println(name + "/" + idx);
            participant_list.remove(idx);
        }
        
        for(int i=0; i<participant_list.size(); i++)
        {
            answer+=participant_list.get(i);
        }*/
        
        return answer;
    }
}