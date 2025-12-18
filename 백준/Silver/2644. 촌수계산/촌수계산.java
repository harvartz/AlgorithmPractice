import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> qu = new LinkedList<>();
    static int N, M;
    static int[][] family;
    static boolean[] visited;
    static int[] dist; // 목표위치로부터 탐색 노드까지의 거리를 나타내는 거리 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        family = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target_parent = Integer.parseInt(st.nextToken()) - 1;
        int target_child = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;

            family[parent][child] = 1;
            family[child][parent] = 1;
        }

        qu.offer(target_parent);
        dist = new int[N];
        visited[target_parent] = true;

   
        while (!qu.isEmpty()) {
            int now = qu.poll();

            if (now == target_child) {
                System.out.println(dist[now]);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (family[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dist[i] = dist[now] + 1;
                    qu.offer(i);
                }
            }
        }
        System.out.println(-1);
    }
}
