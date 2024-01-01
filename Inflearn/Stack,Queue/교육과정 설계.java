import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String essential = br.readLine();
        String sequence = br.readLine();
        System.out.println(T.solution(essential, sequence));
    }

    public String solution(String ess, String seq) {
        Queue<Character> qu = new LinkedList<>();
        Queue<Character> st = new LinkedList<>();

        for (char a : ess.toCharArray()) {
            st.add(a);
        }
        /* 굳이 Queue를 두 개 사용할 필요없다.
         * 그리고 Queue에는 containe() 이라는 메소드가 있어서 peek할 필요가 없음
         * 그러면 밑에 코드처럼 안해도 됨*/
        for (char a : seq.toCharArray()) {
            qu.add(a);
        }

        int count = 0;
        while (!qu.isEmpty()) {
            if (qu.peek() == st.peek()) {
                qu.poll();
                st.poll();
            } else {
                qu.poll();
            }
        }
        String answer;
        if (st.isEmpty()) answer = "YES";
        else answer = "NO";
        return answer;
    }
}