import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 나이트의 이동
* https://www.acmicpc.net/problem/7562
* */
public class BOJ_7562 {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};
    static Queue<Pair> q;
    static int[][] dist;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        for (int x = 0; x < test; x++) {
            size = sc.nextInt();
            dist = new int[size][size];

            Pair start = new Pair(sc.nextInt(), sc.nextInt());
            Pair end = new Pair(sc.nextInt(), sc.nextInt());
            q = new LinkedList<>();

            q.offer(start);
            System.out.println(bfs(end));
        }
    }

    static int bfs(Pair end) {
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            if (pair.x == end.x && pair.y == end.y) {

                return dist[pair.x][pair.y];
            }

            for (int i = 0; i < 8; i++) {
                int d_x = pair.x + dx[i];
                int d_y = pair.y + dy[i];

                if (d_x < 0 || d_x >= size || d_y < 0 || d_y >= size) continue;
                if (dist[d_x][d_y] > 0) continue;
                dist[d_x][d_y] = dist[pair.x][pair.y] + 1;
                q.offer(new Pair(d_x, d_y));
            }
        }
        return 0;
    }


    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}