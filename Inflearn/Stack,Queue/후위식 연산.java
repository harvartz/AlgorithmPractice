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
        // 숫자와 문자와의 차이를 어떻게 구분하는가?
        // Character.isDigit()
        Stack<Integer> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) stack.push(c - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') stack.push(lt + rt);
                else if (c == '-') stack.push(lt - rt);
                else if (c == '*') stack.push(lt * rt);
                else if (c == '/') stack.push(lt - rt);
            }
        }
        int answer = stack.get(0);
        return answer;
    }
    /* 나는 한꺼번에 계산하려고 해서 문제가 되었는데
     *  숫자면 스택에 넣고 연산자면 스택에 2개를 꺼내서 연산 후에 넣는다.*/
}