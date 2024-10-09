import java.io.*;
import java.util.*;

public class Main  {

    static int[][] map;
    static int N, M;
    static int answer = 0;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 입력 코드
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 울타리를 세우는 코드
        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int count) {
        if (count == 3) {
            // 모든 울타리가 세워졌으면 바이러스 전파 후 안전 영역 계산
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2 && !visited[i][j]) {
                    spreadVirusDFS(i, j, tempMap, visited);
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        answer = Math.max(answer, safeArea);
    }

    static void spreadVirusDFS(int x, int y, int[][] tempMap, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int d_x = dx[i] + x;
            int d_y = dy[i] + y;

            if (0 <= d_x && d_x < N && 0 <= d_y && d_y < M) {
                if (tempMap[d_x][d_y] == 0 && !visited[d_x][d_y]) {
                    tempMap[d_x][d_y] = 2;
                    spreadVirusDFS(d_x, d_y, tempMap, visited);
                }
            }
        }
    }
}
