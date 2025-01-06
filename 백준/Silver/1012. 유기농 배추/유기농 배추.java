import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[][] map;
    static int count = 0;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visit = new boolean[m][n];

            int k = Integer.parseInt(st.nextToken());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int d_x = x + dx[i];
            int d_y = y + dy[i];

            if (0 <= d_x && d_x < m && 0 <= d_y && d_y < n) {
                if (map[d_x][d_y] == 1 && !visit[d_x][d_y]) {
                    visit[d_x][d_y] = true;
                    dfs(d_x, d_y);
                }
            }
        }
    }
}