import java.io.*;
import java.util.*;

class Main {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int redGreen = 0;
    static int entire = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 일반 영역 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    entire++;
                }
            }
        }

        // 적록색약을 위해 'G'를 'R'로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
        visited = new boolean[n][n];

        // 적록색약 영역 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    redGreen++;
                }
            }
        }

        System.out.println(entire + " " + redGreen);
    }

    static void bfs(int x, int y, char color) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y});
        visited[x][y] = true;

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == color) {
                        visited[nx][ny] = true;
                        qu.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
