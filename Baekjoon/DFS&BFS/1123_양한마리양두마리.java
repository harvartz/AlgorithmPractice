import java.awt.*;
import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int w;
    static int h;
    static int count;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;

            map = new char[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                String input = br.readLine();
                for (int j = 0; j < h; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (visited[i][j] || map[i][j] == '.') continue;
                    visited[i][j] = true;
                    recur(new Point(i, j));
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void recur(Point p) {

        for (int i = 0; i < 4; i++) {
            int d_x = dx[i] + p.x;
            int d_y = dy[i] + p.y;

            if (d_x < 0 || d_x >= w || d_y < 0 || d_y >= h) continue;
            if (!visited[d_x][d_y] && map[d_x][d_y] == '#') {
                visited[d_x][d_y] = true;
                recur(new Point(d_x, d_y));
            }
        }
    }
}