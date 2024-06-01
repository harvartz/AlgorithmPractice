import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 2583_영역구하기
     * https://www.acmicpc.net/problem/2583*/

    static int[][] map;
    static int m, n, k;
    static int count = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) { // 좌표를 입력 받는 부분
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        int num = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (map[x][y] == 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                    dfs(x, y);
                    num++; // dfs에 나오게 되면 지역을 하나 체크해준다.
                    arr.add(count); // 이전에 count한 것을 배열에 더해준다.
                    count = 0; // 초기화
                }
            }

        }
        System.out.println(num);
        Collections.sort(arr);
        for (int x : arr) {
            System.out.printf("%d ", x);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int d_x = x + dx[i];
            int d_y = y + dy[i];

            if (d_x < 0 || d_x >= n || d_y < 0 || d_y >= m) continue; // 격자판 범위에서 벗어나는 경우
            if (map[d_x][d_y] == 0 && !visited[d_x][d_y]) { // 방문하지 않았으면서 비어있는 경우
                visited[d_x][d_y] = true;
                count++;
                dfs(d_x, d_y);
            }
        }
    }
}