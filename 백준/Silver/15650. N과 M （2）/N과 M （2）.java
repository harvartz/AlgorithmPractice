import java.io.*;
import java.util.*;

class Main {
    static Integer[] answer;
    static boolean[] isUsed;
    static String[] answerDup;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new Integer[m];
        isUsed = new boolean[n + 1];
        answerDup = new String[n];
        recur(1, 0);

        System.out.println(sb);
    }

    static void recur(int at, int depth) {
        if (depth == m) {
            for (int x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = at; i <= n; i++) {
            if (!isUsed[i]) {
                answer[depth] = i;
                recur(i + 1, depth + 1);
            }
        }
    }
}