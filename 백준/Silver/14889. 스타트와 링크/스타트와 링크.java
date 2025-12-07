import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] checked;
    static int min = Integer.MAX_VALUE;

    public static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < checked.length - 1; i++) {
            for (int j = i + 1; j < checked.length; j++) {
                int a = checked[i];
                int b = checked[j];
                teamStart += map[a][b] + map[b][a];
            }
        }

        int[] other = new int[checked.length];
        int idx = 0;
        outer:
        for (int i = 0; i < N; i++) {
            for (int c : checked) {
                if (c == i) {
                    continue outer;
                }
            }
            other[idx++] = i;
        }

        for (int i = 0; i < other.length - 1; i++) {
            for (int j = i + 1; j < other.length; j++) {
                int a = other[i];
                int b = other[j];
                teamLink += map[a][b] + map[b][a];
            }
        }

        int val = Math.abs(teamStart - teamLink);
        min = Math.min(val, min);
    }

    // start 변수는 무엇인가?
    // 문제에서 조합이라는 것을 어떻게 찾아내는가?

    public static void perm(int start, int level) {
        if (level == N / 2) {
            diff();
            return;
        }
        for (int i = start; i < N; i++) {
            checked[level] = i;
            perm(i + 1, level + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new int[N / 2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0, 0);
        System.out.println(min);
    }
}
