import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 메소드를 호출하기 위해 메인 클래스의 인스턴스를 만들어 준다.
        Main T = new Main();
        // for-each를 사용하여 fibo 메소드의 리턴 값은 배열인데 배열의 값을 하나 씩 출력한다.
        for (int x : T.fibo(n)) {
            System.out.print(x + " ");
        }
    }

    // 재귀로 만들지 않고 배열을 사용해서 만들었다.
    public int[] fibo(int n) {
        int[] answer = new int[n];
        // 1번과 2번은 고정이기 떄문에 고정으로 넣어준다.
        answer[0] = 1;
        answer[1] = 1;
        // 그 다음 단순히 구현해주면 된다.
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }

    // 손 코딩의 경우
    public void fibo2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b);
        // 배열을 사용하지 않고 손코딩으로 풀었을 때 코드이다.
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}