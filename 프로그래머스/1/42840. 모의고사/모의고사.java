import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] answer = new int[3];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = 0; // 초기화
        }

        // int형 배열 안에 ArrayList를 가지고 있는 자료구조
        int[][] counts = new int[3][];
        
        counts[0] = new int[]{1,2,3,4,5};
        counts[1] = new int[]{2,1,2,3,2,4,2,5};
        counts[2] = new int[]{3,3,1,1,2,2,4,4,5,5};

        for(int i = 0; i<3; i++){
            int z = 0;
            // 찍는 방식, 문제 답 비교
            for(int j = 0; j < answers.length; j++){
                // System.out.println( i+"번째 수포자, 현재 찍는 방식 값: " + counts[i][z]);
                // System.out.println("인덱스 z: " + z);
                // System.out.println("정답: "+ answers[j]);
                if(counts[i][z] == answers[j]){
                    answer[i]+=1;
                }
                // System.out.println(i+ "번째 수포자 값: " + answer[i]);
                // System.out.println();
                if(z== counts[i].length-1){
                        z = 0;
                }else{
                    z++;
                }
            }
        }
        
        // 해당 최대값일 때 index + 1을 반환해야 한다.
        ArrayList<Integer> result = new ArrayList(); //인덱스를 담은 배열
        int max = Integer.MIN_VALUE;
        int person = 0;
        // 최댓값을 찾는다.
        // 최댓값과 같은 값이 있으면 추가로 더해준다.
        for(int i = 0; i<answer.length; i++){
            max = Math.max(max, answer[i]);
        }
        
        for(int i = 0; i<answer.length;i++){
            if(max == answer[i]){
                result.add(i+1);
            }
        }
        return result;
        
    }
}