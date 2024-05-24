import java.io.*;
import java.util.*;

class Main {
    /*
     * 7576: 토마토
     * https://www.acmicpc.net/problem/7569 */

    static int[][][] map;
    static int M;
    static int N;
    static int H;
    static Queue<Pair> qu = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 6방 탐색을 위한 변수를 선언 (위, 아래)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M]; // 3차원 배열은 다음과 같이 층에 해당하는 인덱스가 처음에 온다.

        qu = new LinkedList<>();

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    map[z][x][y] = Integer.parseInt(st.nextToken());
                    if (map[z][x][y] == 1) qu.offer(new Pair(z, x, y));
                }
            }
        }

        bfs();

        int ans = 0;
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[z][x][y] == 0) {
                        ans = -1;
                        System.out.println(ans);
                        return;
                    }
                    ans = Math.max(ans, map[z][x][y]);
                }
            }
        }
        System.out.println(ans - 1);
    }

    static void bfs() {

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int i = 0; i < 6; i++) {
                int d_x = p.x + dx[i];
                int d_y = p.y + dy[i];
                int d_z = p.z + dz[i];

                if (d_x < 0 || d_x >= N || d_y < 0 || d_y >= M || d_z < 0 || d_z >= H) continue;
                if (map[d_z][d_x][d_y] == 0) {
                    qu.offer(new Pair(d_z, d_x, d_y));
                    map[d_z][d_x][d_y] = map[p.z][p.x][p.y] + 1;
                }
            }
        }
    }

    static class Pair {
        int z;
        int x;
        int y;

        public Pair(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}

