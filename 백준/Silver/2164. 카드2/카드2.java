import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> qu = new LinkedList<>();
        
        for(int i = 1; i<=N; i++){
            qu.offer(i);    
        }

        while(qu.size() != 1){
            qu.poll();
            int out = qu.poll();
            qu.offer(out);
        }

        System.out.println(qu.peek());
        
    }
}