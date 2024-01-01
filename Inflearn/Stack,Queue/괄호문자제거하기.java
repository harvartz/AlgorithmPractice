import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        String answer = "";
        ArrayList<Character> arr = new ArrayList<>();

        Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                /* 조건식에 메소드를 사용하면 메소드를 반드시 실행할 수 밖에 없다
                 * 그렇기 때문에 pop을 한번만 해줘도 되는 것이다*/
                while (st.pop() != '(') ;
            } else {
                st.push(c);
            }
        }

        for (int x = 0; x < st.size(); x++) {
            answer += st.get(x);
        }
        return answer;
    }
}