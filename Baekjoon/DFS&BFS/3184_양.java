import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 3184_양
     * https://www.acmicpc.net/problem/3184 */
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int lambs = 0;
    static int wolves = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int x = 0; x < R; x++) {
            String input = br.readLine();
            for (int y = 0; y < C; y++) {
                map[x][y] = input.charAt(y);
            }
        }

        int wolvesSum = 0;
        int lambsSum = 0;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (visited[x][y] || map[x][y] == '#') continue; // 방문했거나, 울타리이면 다음으로 넘어간다.
                lambs = 0; // 다음 dfs에 들어가기전에, 다음 지역에 들어가기 전에 미리 양과 늑대의 숫자를 초기화를 시켜준다.
                wolves = 0;
                dfs(new Point(x, y));

                if (lambs > wolves) { // 양이 늑대보다 많다면 양의 숫자만 더해준다.
                    lambsSum += lambs;
                } else if (lambs <= wolves) { // 늑대가 양보다 많다면 양의 숫자만 더해준다.
                    wolvesSum += wolves;
                }
            }
        }

        System.out.println(lambsSum + " " + wolvesSum);
    }

    static void dfs(Point p) {

        visited[p.x][p.y] = true;
        if (map[p.x][p.y] == 'o') lambs++; // 해당 위치가 양일 때,
        if (map[p.x][p.y] == 'v') wolves++; // 해당 위치가 늑대일 때,

        for (int i = 0; i < 4; i++) {
            int d_x = p.x + dx[i];
            int d_y = p.y + dy[i];

            if (d_x < 0 || d_x >= R || d_y < 0 || d_y >= C) continue;
            if (map[d_x][d_y] == '#' || visited[d_x][d_y]) continue;

            dfs(new Point(d_x, d_y));
        }
    }
}