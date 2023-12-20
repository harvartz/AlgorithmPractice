import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main T = new Main();
        System.out.println(T.solution(n));
    }

    public int solution(int n) {
        int[] answer = new int[n + 1];
        int count = 0;
        /* 2부터 시작하는 이유는 0과 1은 소수가 아니기 때문이다.
         *  그리고 n+1의 경우는 만약에 인덱스를 실제 숫자와 비교해서 계산해야 하기 때문에
         *  늘려준 것이다. 늘려주지 않으면 OutOfIndex가 일어난다.
         * */
        for (int i = 2; i <= n; i++) {
            /* 만약 해당 수의 값이 0이라면 해당 값은 소수라는 뜻이다.
             *  그리고 이제 해당 값의 배수만큼 값을 1을 넣어줘서 소수가 아니라는 표시를 낸다.
             * */
            if (answer[i] == 0) {
                count++;
                // 배수를 표현하기 위해 i씩 계속 더해주는 것이다.
                for (int j = i; j <= n; j = j + i) {
                    answer[j] = 1;
                }
            }
        }
        return count;
    }
}