import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 �이스의 개수

        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine()); // 정수 n
            count = 0; // 카운트 초기화
            dfs(n, 0);
            sb.append(count).append("\n"); // 결과를 StringBuilder에 저장
        }

        System.out.print(sb); // 모든 결과를 한 번에 출력
    }

    // DFS 함수
    public static void dfs(int target, int sum) {
        if (sum == target) {
            count++; // 합이 target과 같으면 카운트 증가
            return;
        }
        if (sum > target) {
            return; // 합이 target을 초과하면 더 이상 탐색하지 않음
        }

        // 1, 2, 3을 더하는 경우를 재귀적으로 탐색
        dfs(target, sum + 1);
        dfs(target, sum + 2);
        dfs(target, sum + 3);
    }
}