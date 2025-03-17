import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[][] arr;
    static int[] b; // A팀의 선수들 저장
    static int min = Integer.MAX_VALUE; // 최솟값을 구해야 하므로 Integer.MAX_VALUE로 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        b = new int[N / 2]; // A팀은 N/2명의 선수로 구성됨

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합으로 A팀 선수들을 선택
        recur(0, 0);
        System.out.println(min);
    }

    // 조합을 이용해 A팀(N/2명)을 구성하는 함수
    static void recur(int start, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = start; i < N; i++) {
            b[depth] = i; // A팀의 선수 추가
            recur(i + 1, depth + 1);
        }
    }

    // A팀과 B팀의 차이를 계산하는 함수
    static void diff() {
        boolean[] isATeam = new boolean[N]; // A팀인지 여부를 저장하는 배열

        // A팀의 선수들을 표시
        for (int i = 0; i < N / 2; i++) {
            isATeam[b[i]] = true;
        }

        int team_start = 0, team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // A팀의 경우
                if (isATeam[i] && isATeam[j]) {
                    team_start += arr[i][j] + arr[j][i];
                }
                // B팀의 경우 (A팀이 아닌 경우)
                else if (!isATeam[i] && !isATeam[j]) {
                    team_link += arr[i][j] + arr[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}
