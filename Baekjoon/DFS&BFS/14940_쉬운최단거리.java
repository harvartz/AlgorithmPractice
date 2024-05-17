import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int map[][];
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Pair> qu;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m]; // 입력받은 2차원 배열이자, 거리를 재는 배열
        visited = new boolean[n][m]; // 방문했는지 확인하는 배열

        int i = 0;
        int j = 0;

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                if (map[x][y] == 2) { // 2인 경우는 시작점이기 때문에, 시작을 위한 좌표를 저장해둔다.
                    map[x][y] = 0; // 시작점이기 때문에 거리는 0이여야 한다. 그래서 0으로 바꿔준다.
                    i = x; // 좌표를 저장해준다.
                    j = y;
                }
            }
        }

        qu = new LinkedList<>(); // BFS에 사용할 자료구조 큐이다.

        bfs(i, j); // bfs 시작이다

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    map[x][y] = -1;
                }
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {

        qu.add(new Pair(x, y)); // 시작좌표를 넘겨 받아서 큐에 넣는다.
        visited[x][y] = true; // 시작 좌표는 방문 처리를 한다. 다른 좌표에서 방문하지 않도로고 하기 위해서

        while (!qu.isEmpty()) {
            Pair p = qu.poll(); // 탐색 기준이 될 좌표를 뽑는다.

            for (int i = 0; i < 4; i++) { // 기준 좌표를 기준으로 사방 탐색을 한다.
                int d_x = p.x + dx[i];  // 탐색할 x좌표
                int d_y = p.y + dy[i];  // 탐색할 y좌표
                if (d_x < 0 || d_y < 0 || d_x >= n || d_y >= m) continue; // 지도에서 벗어나는 경우는 넘어간다
                if (visited[d_x][d_y] || map[d_x][d_y] == 0) continue; // 방문했거나, 0은 갈 수 없는 땅이기 때문에 넘어간다.
                qu.add(new Pair(d_x, d_y)); // 위의 조건을 모두 통과하면 탐색할 수 있는 좌표이다. 그래서 큐에 넣는다.
                visited[d_x][d_y] = true; // 큐에 넣은 좌표는 방문할 좌표이기 때문에 방문 처리를 한다.
                map[d_x][d_y] = map[p.x][p.y] + 1; // 탐색한 좌표의 값은 기준 좌표의 값에서 + 1을 해준다.
                                                    // 이렇게 되면 탐색할 때마다 시작 좌표로부터 1씩 증가하여 거리를 계산하게 된다.
            }
        }
    }
}
