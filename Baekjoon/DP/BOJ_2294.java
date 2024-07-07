import java.io.*;
import java.util.*;

class Main {
    /*
     * boj_2294 :https://www.acmicpc.net/problem/2294
     * 목표 가치를 얻기위해서 사용해야 하는 최소 동전 갯수를 구하는 문제
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 가치의 합 K
        int[] coin = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 초기화 (dp[i]는 i 금액을 만드는 데 필요한 최소 동전 개수)
        int[] dp = new int[k + 1];

        // dp 배열을 최댓값으로 초기화. -1을 빼는 이유는 오버플로우를 방지하기 위해
        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // dp[0]은 0으로 초기화. 금액이 0일 때 필요한 동전 개수는 0개
        dp[0] = 0;

        // 각 동전의 가치를 사용하여 dp 배열 갱신
        for (int i = 1; i <= n; i++) { // 동전의 갯수를 반복하기 위해 사용하는 반복문
            for (int j = coin[i]; j <= k; j++) { // 동전의 값어치 부터 K라는 가치의 합까지의 필요한 최소 동전 갯수를 확인하기 위한 반복문
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                // dp[coin[i]]: i번째 동전의 가치를 만드는데 필요한 최소 동전
                // Math.min(dp[j], dp[j-coin[i]] + 1) : i번재 동전의 가치를 만드는데 필요한 최소 동전, j라는 값어치 - i번째 동전 가격을 만드는데 필요한 최소 동전, 중 작은 값 대입
            }
        }

        // 목표 금액 k를 만들 수 없는 경우 -1 출력, 만들 수 있는 경우 최소 동전 개수 출력
        if (dp[k] == Integer.MAX_VALUE - 1)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}