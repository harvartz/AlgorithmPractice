import java.io.*;
import java.util.*;

class Main {

    static int N, M, K, X;
    static List<List<Integer>> graph;
    static List<Integer> answer;
    static Queue<Integer> qu;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];
        // -1 은 아직 방문 안함
        Arrays.fill(dist, -1);

        // 양방향 그래프
        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(X);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int x : answer) {
                System.out.println(x);
            }
        }
    }

    static void bfs(int start) {
        qu = new LinkedList<>();
        answer = new ArrayList<>();
        qu.offer(start);
        dist[start] = 0;

        while (!qu.isEmpty()) {
            int now = qu.poll();

            for (int next : graph.get(now)) {
                // 방문 안했으면?
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    if (dist[next] == K) {
                        answer.add(next);
                    }
                    qu.offer(next);
                }
            }
        }
    }
}