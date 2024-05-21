import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {
    /*
     * 16956_늑대와 양
     * https://www.acmicpc.net/problem/16956
     * 스페셜 져지라 답이 다양하다
     * */
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char map[][];
    static int[] d_x = {-1, 0, 1, 0};
    static int[] d_y = {0, -1, 0, 1};
    static Queue<Pair> qu;
    static int R, C;
    static boolean possible; // possible - false (0): 늑대가 갈 수 잇다. true(1) : 늑대가 갈 수 없다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        qu = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') { // 양들 주위로 울타리를 치기 위해서 양에 대한 좌표가 나오면 큐에 넣는다.
                    qu.offer(new Pair(i, j));
                }
            }
        }
        bfs();

        if (!possible) { // 늑대가 갈 수 없다
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        } else System.out.println(0); // 늑대갈 수 있으면 1을 출력한다

    }

    public static void bfs() {

        while (!qu.isEmpty()) {
            Pair p = qu.poll(); // 양을 기준점을 삼아서 주변을 탐색한다.
                                // 양에 대한 좌표를 먼저 꺼낸다.

            for (int x = 0; x < 4; x++) {
                int dx = p.x + d_x[x];
                int dy = p.y + d_y[x];
                // 지도 범위에서 벗어나는 경우
                if (dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
                // 탐색하는 좌표에 늑대가 있으면 울타리를 치지 못하고 늑대한테 잡아먹힌다.
                if (map[dx][dy] == 'W') possible = true;

                if (map[dx][dy] == '.') { // 양 주위에 공간이 남아있으면 전부 울타리를 친다.
                    map[dx][dy] = 'D';
                }
            }
        }
    }
}
