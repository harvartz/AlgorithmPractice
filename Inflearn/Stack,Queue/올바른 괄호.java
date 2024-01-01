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

        char[] arr = str.toCharArray();
        Stack<Character> st = new Stack<>();

        for (int x = 0; x < arr.length; x++) {
            if (!st.isEmpty() && st.peek() == '(' && arr[x] == ')') {
                st.pop();
            } else {
                st.push(arr[x]);
            }
        }
        // 넣기 전에 괄호를 미리 뽑아보고 다음에 넣을 부분이 닫는 괄호라면 push하지 않고 pop하면 된다.
        // stack이 비어있을 때는 어떻게 해야하는가?

        if (st.isEmpty()) {
            answer = "YES";
        } else answer = "NO";


        return answer;

    }

}