import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 13565_침투
     * https://www.acmicpc.net/problem/13565 */
    static int N, M;
    static int[][] graph;
    static boolean[][] visited; // 방문 처리하는 2차원 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Point> startPoint = new ArrayList<>(); // 바깥쪽에서 처음 침투되는 지점을 담아두는 배열리스트
    static boolean pass = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for (int x = 0; x < M; x++) {
            String input = br.readLine();
            for (int y = 0; y < N; y++) {
                graph[x][y] = input.charAt(y) - '0'; // 공백없이 붙어있기 때문에 다음과 같이 문자를 하나씩 분리후에 문자 0을 빼준다.
                if (x == 0 && graph[x][y] == 0) { // 바깥쪽에서 처음 시작하고, 해당 지점이 전류가 통할 수 있는 지점일 때
                    startPoint.add(new Point(x, y)); // startPoint에 대입한다.
                }
            }
        }

        if (startPoint.isEmpty()) { // 만약 startPoint가 비어있는 경우 -> 바깥쪽에서 처음 들어오는 지점이 전부 막혀있는 경우
            pass = false;
            System.out.println("NO"); // NO를 출력하고 바로 종료한다.
            return;
        }

        for (Point p : startPoint) {
            if (visited[p.x][p.y]) continue; // 이전 첫번째 지점에서 순회한 부분이 다음 첫번째 지점과 붙어 있는 경우
            if (graph[p.x][p.y] == 1) continue; // 막혀 있는 경우는 넘어간다.
            visited[p.x][p.y] = true; // 미리 여기에서 방문처리를 한다.
            dfs(p);
        }

        System.out.println(pass ? "YES" : "NO");
    }

    static void dfs(Point p) {
        if (p.x == M - 1) { //p.x가 M-1이라면 안쪽 통과 지점과 맞닿아 있기 때문에 통과 가능할 수 있다.
            pass = true;
            return;
        }

        for (int i = 0; i < 4; i++) { // 4방 탐색을 시작한다.
            int d_x = p.x + dx[i];
            int d_y = p.y + dy[i];
            if (d_x >= 0 && d_x < M && d_y >= 0 && d_y < N) { // map의 크기에서 벗어나는 경우
                if (graph[d_x][d_y] == 0 && !visited[d_x][d_y]) { // 전류가 통할 수 있고 아직 방문하지 않은 지점
                    visited[d_x][d_y] = true; // 방문처리한다.
                    dfs(new Point(d_x, d_y));
                }
            }
        }
    }
}


