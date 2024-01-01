import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(T.solution(input));
    }

    public int solution(String input) {

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        /* 문자열을 탐색한다.
         *  나는 탐색해서 문자열을 하나씩 소거하면서 진행한다고 생각했는데
         *  그냥 탐색하면서 하나씩 진행할 수 있다는 것을 알았다*/
        for (int i = 0; i < input.length(); i++) {
            // 1. 괄호가 ( 이면 무조건 스택에 쌓는다.
            if (input.charAt(i) == '(') stack.push('(');
            else {
                // 2. ')'이면 '('를 pop한다. -> 레이저를 쏜다는 의미
                stack.pop();
                // 3. 탐색하는 문자 전의 문자를 확인하여 '('이면 막대기의 구분선
                if (input.charAt(i - 1) == '(') answer += stack.size();
                    // 4. 막대기의 끝임을 확인하고 하나를 더해준다.
                else answer++;
            }
        }
        return answer;
    }
    /* 위와 같이 4단계를 생각해낼 수 있는가 없는가가 관건이다.
     *  나는 왜 생각을 하지 못했지? 단순히 생각이 얽히고 섥켜서 복잡하게 생각했다.
     *  하지만 단계별로 하나씩 생각하려고 하자.*/
}