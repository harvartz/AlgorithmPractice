import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {

    /* 4963_섬의개수
    *  https://www.acmicpc.net/problem/4963
    * */

    static int[] d_x = {-1, 0, 1, 0, 1, -1, -1, 1};
    static int[] d_y = {0, -1, 0, 1, 1, 1, -1, -1};

    static Queue<Pair> qu = new LinkedList<>();
    static boolean[][] visited;

    static int w;
    static int h;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int x = 0; x < h; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < w; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int x = 0; x < h; x++) {
                for (int y = 0; y < w; y++) {
                    if (visited[x][y]) continue;
                    if (map[x][y] == 1) { // 땅인 곳부터 시작해야 이어져 있는 것을 볼 수 있다.
                        //bfs(x, y);
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true; // 처음 들어오면 방문 처리를 해준다.

        qu.offer(new Pair(x, y)); // 큐에 넣고
        while (!qu.isEmpty()) { // 큐가 비어있을 때 까지 계속 반복한다
            Pair p = qu.poll();
            for (int i = 0; i < 8; i++) { // 8방 탐색을 한다
                int dx = p.x + d_x[i];
                int dy = p.y + d_y[i];

                if (dx >= 0 && dy >= 0 && dx < h && dy < w && !visited[dx][dy]) { // map 범위 안에 들어가있고, 방문을 아직 하지 않은 경우
                    if (map[dx][dy] == 1) { // 그런데 땅인 경우
                        visited[dx][dy] = true; // 방문처리를 해준다
                        qu.offer(new Pair(dx, dy)); // 큐에 넣고
                    }
                }
            }
        }
    }

    public static void dfs(int x, int y) {
        if (visited[x][y]) return;
        visited[x][y] = true; // dfs의 경우 먼저 방문처리를 해준다
        for (int i = 0; i < 8; i++) {
            int dx = x + d_x[i];
            int dy = y + d_y[i];

            if (dx >= 0 && dy >= 0 && dx < h && dy < w) { // map 범위 안에 있고
                if (map[dx][dy] == 1) { // 땅인 경우
                    dfs(dx, dy); // 깊이 우선 탐색에 들어간다
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
