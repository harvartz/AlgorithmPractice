import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 연결 요소의 개수
* https://www.acmicpc.net/problem/11724
* */
public class BOJ_11724 {
    public static int[][] adj;
    public static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        // 그래프 입력 처리
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new int[n + 1][n + 1];
        vis = new boolean[n + 1];

        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        // BFS
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            num++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt = 1; nxt <= n; nxt++) {
                    if (adj[cur][nxt] == 1 && !vis[nxt]) {
                        q.add(nxt);
                        vis[nxt] = true;
                    }
                }
            }
        }
        System.out.println(num);
    }
}