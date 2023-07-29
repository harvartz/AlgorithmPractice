import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 경로 찾기
* https://www.acmicpc.net/problem/11403
* */
public class BOJ_11403 {
    static int[][] graph;
    static int[][] result;
    static boolean[] visit;
    static int N;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < N; i++) {
                if (graph[temp][i] == 1 && visit[i] == false) {
                    q.offer(i);
                    visit[i] = true;
                    result[start][i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}