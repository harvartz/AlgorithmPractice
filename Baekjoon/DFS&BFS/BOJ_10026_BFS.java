import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
*
* 적록색약
* https://www.acmicpc.net/problem/10026
* */
public class BOJ_10026_BFS {
    static char[][] pic;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> qu;

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        pic = new char[n][n];
        visited = new int[n][n];
        qu = new LinkedList<>();


        // 적록 색약이 아닌 경우,
        for (int x = 0; x < n; x++) {
            String str = br.readLine();
            char[] split = str.toCharArray();
            for (int y = 0; y < n; y++) {
                pic[x][y] = split[y];
            }
        }

        int count = 0;
        bfs(count);

        visited = new int[n][n];
        qu = new LinkedList<>();
        count = 0;

        // 적록 색약인 경우
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (pic[x][y] == 'R') {
                    pic[x][y] = 'G';
                }
            }
        }
        bfs(count);
    }

    static void bfs(int count) {

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (visited[x][y] == 1) continue;
                qu.offer(new Pair(x, y));
                visited[x][y] = 1;

                while (!qu.isEmpty()) {
                    Pair pair = qu.poll();

                    for (int z = 0; z < 4; z++) {
                        int d_x = pair.x + dx[z];
                        int d_y = pair.y + dy[z];

                        if (d_x < 0 || d_y < 0 || d_x >= n || d_y >= n) continue;
                        if (pic[pair.x][pair.y] != pic[d_x][d_y] || visited[d_x][d_y] == 1) continue;
                        visited[d_x][d_y] = 1;
                        qu.offer(new Pair(d_x, d_y));
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        Pair pair = new Pair(x, y);
        for (int z = 0; z < 4; z++) {
            int d_x = dx[z] + pair.x;
            int d_y = dy[z] + pair.y;

            if (d_x < 0 || d_y < 0 || d_x >= n || d_y >= n) continue;
            if (visited[d_x][d_y] == 1 || pic[pair.x][pair.y] != pic[d_x][d_y]) continue;
            visited[d_x][d_y] = 1;
            dfs(d_x, d_y);
        }
    }


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
