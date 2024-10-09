import java.io.*;
import java.util.*;

class Solution {
    public static class PlayList{
        int idx;
        int play;
        
        public PlayList(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
    
    
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        
        // value 값에 genres, key 값에 plays 를 넣어준다. 
        // -> 모든 장르를 재생된 횟수가 다르다는 제한사항이 있다
    
        // 1. 제일 플레이가 많이 된 장르를 찾는다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> mapToGenres = new ArrayList<>();
        for(String item : map.keySet()){
            mapToGenres.add(item);
        }
        mapToGenres.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        // 2. 장르별로 분리한 뒤 play 순으로 정렬을 하여 결과 값에 넣어준다.
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(String item : mapToGenres){
        ArrayList<PlayList> playLists = new ArrayList<>();
        for(int i = 0; i < genres.length; i++){
            if(item.equals(genres[i])){
                playLists.add(new PlayList(i, plays[i]));
            }
        }
        
        playLists.sort((o1, o2) -> {
            if(o1.play == o2.play){
                return o1.idx - o2.idx;
            }
            return o2.play - o1.play;
        });
        
        answer.add(playLists.get(0).idx);
        if(playLists.size() != 1){
            answer.add(playLists.get(1).idx);
        }
        }
        // 장르 내에서 많이 재생된 노래를 먼저 수록
        return answer;
    }
}