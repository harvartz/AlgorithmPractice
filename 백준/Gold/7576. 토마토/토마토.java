import java.io.*;
import java.util.*;

// 토마토 문제
// 하나의 토마토에 (4방향)인접한 토마토는 익게 됨
// 안익은 토마토가 최소 몇일이 지나야 모든 토마토가 익게 될까? 

class Main {

    static int N, M;
    static int[][] map;
    static int[][] time;

    static Queue<int[]> tomato = new LinkedList<>();
    static Queue<int[]> qu = new LinkedList<>();

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void bfs() {

        while (!qu.isEmpty()) {
            int[] now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int d_x = now[0] + dx[i];
                int d_y = now[1] + dy[i];

                if (0 <= d_x && d_x < M && 0 <= d_y && d_y < N) {
                    if (map[d_x][d_y] == 0) {
                        map[d_x][d_y] = map[now[0]][now[1]] + 1;
                        qu.offer(new int[] { d_x, d_y });
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    qu.offer(new int[] { i, j });
                }
            }
        }

        bfs();
        int answer = Integer.MAX_VALUE;
        answer = findTime();
        if (answer == -1) {
            System.out.println(-1);
        } else {
            System.out.println(answer - 1);
        }
    }

    public static int findTime() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}