import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int safeArea;
    static int nowArea;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        safeArea = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        for (int i = minHeight; i <= maxHeight; i++) {
            int nowArea = 0;
            visited = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && map[x][y] > i) {
                        dfs(x, y, i);
                        nowArea++;
                    }
                }
            }
            safeArea = Math.max(nowArea, safeArea);
        }
        System.out.println(safeArea);
    }

    static void dfs(int x, int y, int nowHeight) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int d_x = dx[i] + x;
            int d_y = dy[i] + y;

            if (0 <= d_x && d_x < N && 0 <= d_y && d_y < N) {
                if (!visited[d_x][d_y] && map[d_x][d_y] > nowHeight) {
                    dfs(d_x, d_y, nowHeight);
                }
            }
        }
    }
}