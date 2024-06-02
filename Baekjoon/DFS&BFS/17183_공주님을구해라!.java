import java.io.*;
import java.util.*;

// Position 클래스는 좌표 (x, y)와 그 위치까지의 시간을 저장하는 데 사용됩니다.
class Position {
    int x, y, time;

    Position(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Main {
    /*
     * 17836_공주님을구해라!
     * https://www.acmicpc.net/problem/17836
     * 문제를 잘못 해석했다. 그람을 획득하면 하나의 벽만 부술 수 있는 줄 알았지만 그런 조건은 존재하지 않았다.
     * 즉 그람까지의 최단 거리를 구한 후에, 그람을 구한 순간부터 목적지까지의 단순 거리 계산을 하면된다.
     * */
    static int N, M, T; // 미로의 크기 N x M과 제한 시간 T
    static int[][] map; // 미로를 저장하는 2차원 배열
    static boolean[][] visited; // 방문 여부를 저장하는 2차원 배열
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 x 좌표 변화량
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동을 위한 y 좌표 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 미로의 크기와 제한 시간을 입력받습니다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 미로 정보를 입력받습니다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS를 사용하여 최소 시간을 계산합니다.
        int result = bfs();

        // 계산된 시간이 제한 시간을 초과하거나 경로가 없는 경우 "Fail"을 출력합니다.
        if (result == -1 || result > T) {
            System.out.println("Fail");
        } else {
            // 그렇지 않으면 최소 시간을 출력합니다.
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 0)); // 시작점 (0, 0)에서 BFS를 시작합니다.
        visited[0][0] = true; // 시작점을 방문 표시합니다.

        int minTime = Integer.MAX_VALUE; // 최소 시간을 저장할 변수
        int gramTime = -1; // 그람을 찾은 시간을 저장할 변수
        Position gramPos = null; // 그람의 위치를 저장할 변수

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            // 현재 위치가 그람의 위치인 경우
            if (map[pos.x][pos.y] == 2) {
                gramPos = pos; // 그람의 위치를 저장합니다.
                gramTime = pos.time; // 그람을 찾은 시간을 저장합니다.
            }

            // 현재 위치가 도착점인 경우
            if (pos.x == N - 1 && pos.y == M - 1) {
                minTime = Math.min(minTime, pos.time); // 최소 시간을 갱신합니다.
            }

            // 상하좌우로 이동합니다.
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                // 이동할 위치가 미로 범위 내에 있고, 방문하지 않았으며, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true; // 방문 표시합니다.
                    queue.offer(new Position(nx, ny, pos.time + 1)); // 새로운 위치를 큐에 추가합니다.
                }
            }
        }

        // 그람을 찾은 경우
        if (gramTime != -1) {
            // 그람을 획득한 위치에서 도착점까지의 맨해튼 거리를 계산합니다.
            int gramToEndTime = gramTime + (N - 1 - gramPos.x) + (M - 1 - gramPos.y);
            minTime = Math.min(minTime, gramToEndTime); // 최소 시간을 갱신합니다.
        }

        // 최소 시간이 갱신되지 않은 경우 -1을 반환합니다.
        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}
