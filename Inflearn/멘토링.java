import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인덱스를 처음부터 처리해서 진행하는게 직관적이긴 할 것 같다.
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(n, m, arr));
    }

    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) { //멘토
            for (int j = 1; j <= n; j++) { //멘티
                if (i == j) continue;

                int count = 0;
                int mentor = 0;
                int mentee = 0; //멘토 멘티의 등수

                for (int k = 0; k < m; k++) { //k번째 시험

                    for (int s = 0; s < n; s++) { //등수

                        if (arr[k][s] == i) mentor = s;
                        if (arr[k][s] == j) mentee = s;
                    }

                    if (mentor < mentee) { //멘토가 등수가 더 높으면
                        count++;
                    }
                }

                if (count == m) { //멘토가 모든 시험에서 앞서면
                    answer++;
                }
            }
        }

        return answer;
    }
}