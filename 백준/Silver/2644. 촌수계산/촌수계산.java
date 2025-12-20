import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int targetParent, targetChild;
    static boolean[] visited;
    static Queue<int[]> qu = new LinkedList();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        targetParent = Integer.parseInt(st.nextToken()) - 1;
        targetChild = Integer.parseInt(st.nextToken()) - 1;

        // System.out.println(targetParent);
        // System.out.println(targetChild);
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;

            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        qu.offer(new int[] { targetParent, 0 });

        visited[targetParent] = true;

        while (!qu.isEmpty()) {
            int[] now = qu.poll();
            // System.out.println("now: " + now[0] + ", dist: " + now[1] + " ");

            if (now[0] == targetChild) {
                System.out.println(now[1]);
                return;
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i] && map[now[0]][i] == 1) {
                    visited[i] = true;
                    qu.offer(new int[] { i, now[1] + 1 });
                }
            }
        }
        System.out.println(-1);
    }
}