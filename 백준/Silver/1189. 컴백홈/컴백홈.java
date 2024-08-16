import java.io.*;
import java.util.*;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int R;
    static int C;
    static int K;
    static int count = 1;
    static int answer = 0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        // 시작을 오른쪽 밑에서부터 시작하기 때문에
        visited[R - 1][0] = true;
        dfs(R - 1, 0);
        System.out.println(answer);
    }


    static public void dfs(int x, int y) {
        // System.out.println("x: " + x + ",y: " + y);
        // 오른쪽 위에를 방문하면 탐색을 종료한다.
        if (x == 0 && y == C - 1) {
            if (count == K) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int d_x = x + dx[i];
            int d_y = y + dy[i];

            if (0 <= d_x && d_x < R && 0 <= d_y && d_y < C) {
                if (!visited[d_x][d_y] && map[d_x][d_y] != 'T') {
                    visited[d_x][d_y] = true;
                    count++;
                    //System.out.println("d_x: " + d_x + " ,d_y: " + d_y + " ,count: " + count);
                    dfs(d_x, d_y);
                    count--;
                    visited[d_x][d_y] = false;
                }
            }
        }
    }
}