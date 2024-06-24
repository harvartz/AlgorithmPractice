import java.awt.Point;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 2468_안전영역
     * https://www.acmicpc.net/problem/2468 */

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        int rangeMax = Integer.MIN_VALUE;
        int rangeMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                rangeMax = Math.max(input, rangeMax);
                rangeMin = Math.min(input, rangeMin);
            }
        }

        max = 1;
        for (int z = 1; z < rangeMax; z++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > z) {
                        dfs(new Point(i, j), z);
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

    static void dfs(Point p, int level) {

        visited[p.x][p.y] = true;
        for (int i = 0; i < 4; i++) {
            int d_x = p.x + dx[i];
            int d_y = p.y + dy[i];

            if (0 <= d_x && d_x < N && 0 <= d_y && d_y < N) {
                if (!visited[d_x][d_y] && map[d_x][d_y] > level) {
                    dfs(new Point(d_x, d_y), level);
                }
            }
        }
    }
}