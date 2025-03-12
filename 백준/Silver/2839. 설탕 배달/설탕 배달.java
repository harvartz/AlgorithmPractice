import java.io.*;


public class Main { 
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];

        // 만약 N이 3 이상이면 3kg 설탕봉지 하나로 만들 수 있음 (dp[3] = 1)
        if (N >= 3)
            dp[3] = 1;
        
        // 만약 N이 5 이상이면 5kg 설탕봉지 하나로 만들 수 있음 (dp[5] = 1)
        if (N >= 5)
            dp[5] = 1;

        // DP 테이블을 채워나가기 (Bottom-up 방식)
        for (int i = 6; i <= N; i++) {
            // 5kg 봉지를 사용할 수 있는 경우
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } 
            // 3kg 봉지를 사용할 수 있는 경우
            else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } 
            // 3kg과 5kg 봉지를 조합해서 만들 수 있는 경우
            else {
                // dp[i-3]과 dp[i-5] 둘 다 0이 아니어야 만들 수 있음
                if (dp[i - 3] != 0 && dp[i - 5] != 0) {
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1; // 최소 봉지 개수 선택
                }
            }
        }

        // 만약 dp[N]이 0이면 정확히 Nkg를 만들 수 없는 경우이므로 -1 출력
        if (dp[N] == 0) {
            System.out.println("-1");
            return;
        }
        
        // 최소 봉지 개수 출력
        System.out.println(dp[N]);
    }
}