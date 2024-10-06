import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int count = 0;
    static int Max = 0; // 초기값을 0으로 설정

    public static void main(String[] args) throws IOException {
        // 제출 시 파일 입력 제거
        // System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int height = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE; // 실제 최소 높이로 설정
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        // 물 높이를 0부터 최대 높이까지 고려
        for (int i = 0; i <= height; i++) { // 0부터 시작
            visited = new boolean[n][n];
            count = 0;
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < n; z++) {
                    if (!visited[j][z] && map[j][z] > i) {
                        count++;
                        dfs(j, z, i);
                    }
                }
            }
            Max = Math.max(count, Max);
        }
        System.out.println(Max);
    }

    static void dfs(int x, int y, int level) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int d_x = x + dx[i];
            int d_y = y + dy[i];
            if (0 <= d_x && d_x < n && 0 <= d_y && d_y < n) {
                if (!visited[d_x][d_y] && map[d_x][d_y] > level) {
                    dfs(d_x, d_y, level);
                }
            }
        }
    }
}
