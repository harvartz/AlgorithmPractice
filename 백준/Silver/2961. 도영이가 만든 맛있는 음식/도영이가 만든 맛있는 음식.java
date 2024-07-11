import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] input;
    static int[] answer;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N][2]; // 첫번째 인덱스는 각 음식을 나타냄, 두번째 인덱스 0: 신맛, 1: 쓴맛
        answer = new int[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);
        System.out.println(result);
    }

    static void recur(int level, int start) {
        if (level > 0) { // level이 0이 아닌 경우 조합을 고려
            int sour = 1; // 신맛 (곱)
            int bitter = 0; // 쓴맛 (합)

            for (int i = 0; i < level; i++) {
                sour *= input[answer[i]][0];
                bitter += input[answer[i]][1];
            }

            result = Math.min(result, Math.abs(sour - bitter));
        }

        for (int i = start; i < N; i++) {
            answer[level] = i;
            recur(level + 1, i + 1);
        }
    }
}
