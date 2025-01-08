import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static int M;
    static int N;
    static Queue<Pair> qu = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        qu = new LinkedList<>();

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 1) qu.offer(new Pair(x, y));
            }
        }

        bfs();

        int ans = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 0) {
                    ans = -1;
                    System.out.println(ans);
                    return;
                }
                ans = Math.max(ans, map[x][y]);
            }
        }
        System.out.println(ans - 1);
    }

    static void bfs() {

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int d_x = p.x + dx[i];
                int d_y = p.y + dy[i];

                if (d_x < 0 || d_x >= N || d_y < 0 || d_y >= M) continue;
                if (map[d_x][d_y] == 0) {
                    count++;
                    map[d_x][d_y] = map[p.x][p.y] + 1;
                    qu.offer(new Pair(d_x, d_y));
                }
            }
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

