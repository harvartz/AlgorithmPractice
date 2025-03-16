import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 정점 개수
        graph = new int[N][N];
        result = new int[N][N];

        // 그래프 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 모든 정점에 대해 BFS 수행
        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    // BFS를 사용하여 i번 정점에서 도달 가능한 노드를 찾음
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < N; next++) {
                // 갈 수 있는 길이 있고, 방문하지 않았다면 탐색
                if (graph[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    result[start][next] = 1; // 도달 가능 표시
                    queue.add(next);
                }
            }
        }
    }
}