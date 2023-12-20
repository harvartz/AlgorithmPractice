import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            answer[x] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        System.out.println(T.solution(n, answer));

    }

    public int solution(int n, int[] answer) {
        int sum = 0;
        int tmp = 0;

        for (int x = 0; x < n; x++) {
        /*
             내가 왜 이렇게 생각했을까?
             그냥 다음 순서의 배열을 고려할 필요가 전혀 없는 것이
             내가 봤을 때는 규칙을 처음에 잘못 수립한 것 같다.
             그냥 현재 배열값이 0이 되면 tmp를 0으로 바꿔주기만 하면 된다.
             */
            if (answer[x] == 0) {
                tmp = 0;
            }
            // else를 사용하지 않았더니 모든 경우에 체크가 되어서 문제가 되는 경우가 있었다. 그러니 else를 써야할지 안써야할 지 항상 생각하기!
            else {
                tmp++;
                sum += tmp;
            }
        }
        return sum;
    }
}