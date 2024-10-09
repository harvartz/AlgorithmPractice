import java.util.*;
import java.io.*;

class Solution {
    
    public String solution(int[] numbers) {
        
        String answer = "";
        
        // 정렬 1차로 해주기...
        String [] num = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
        {
            num[i] = String.valueOf(numbers[i]);
        }
        
        //Arrays.sort(num, Collections.reverseOrder());
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        /*for(int i=0; i<numbers.length; i++)
        {
            
            System.out.print(numbers[i] + " ");
        }
        System.out.println();*/
        
        // 2차 정렬 => 818,81 or 816,81
        for(int i=0; i<num.length-1; i++)
        {
            String tmp1 = num[i]+num[i+1];
            String tmp2 = num[i+1]+num[i];
                
            if(tmp1.compareTo(tmp2) <= 0)
            {
                // 303, 330 => 순서를 변경해야하는 경우
                String tmp3 = num[i];
                num[i] = num[i+1];
                num[i+1] = tmp3;
                    
                //System.out.println("1."+tmp1 + "/" + tmp2);
            }   
            
            answer+=num[i];
        }
        
        answer+=num[num.length-1];
        
        //answer+=num[num.length-1];
        

       // 000인 경우 => 0으로 나와야 한다
       if (answer.charAt(0) == '0')
       {
           answer = "0";
       }
        
       return answer;
    }
}






/*import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String [] tmp_arr = new String[numbers.length];
        
        for(int i =0; i<numbers.length; i++)
        {
            tmp_arr[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(tmp_arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        String answer = "";
        if (tmp_arr[0].equals("0") == false) 
        {
            for(int i=0; i<numbers.length; i++)
            {
                answer+=tmp_arr[i];
            }
        }
        else
        {
            answer = "0";
        }
        
        return answer;
    }
}*/