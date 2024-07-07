import java.io.*;
import java.util.*;

class Main {
    /*
     * boj_12865: https://www.acmicpc.net/problem/12865
     *
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 들 수 있는 최대 무게 K

        int[] w = new int[N + 1]; // 무게 배열
        int[] v = new int[N + 1]; // 가치 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        // dp 배열의 값은 인덱스 무게일 때 가질 수 있는 최대 물건의 가치
        int[] dp = new int[K + 1];

        // 처음에는 Integer.MAX_VALUE로 초기화 했는데
        // 0으로 초기화 해야 한다, 이유는 선택하지 않을 때의 기본 값이 0이기 때문이다.
        Arrays.fill(dp, 0);

        for (int i = 1; i <= N; i++) { // 첫번째 부터 N번쨰 아이템까지 반복문
            for (int j = K; j > 0; j--) { // 첫번째 아이템의 무게부터 최대 무게 K까지
                if (w[i] <= j) { // 비교하려는 아이템의 무게가 최대 무게보다 작을 때
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[K]);
    }
}