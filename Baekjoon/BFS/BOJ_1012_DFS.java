import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 유기농 배추 (DFS)
 * https://www.acmicpc.net/problem/1012
 * */
public class BOJ_1012_DFS {
    static int[][] land;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int column;
    static int row;
    static Queue<Pair> qu;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();


        for (int x = 0; x < test; x++) {
            column = sc.nextInt();
            row = sc.nextInt();
            int num = sc.nextInt();

            qu = new LinkedList<>();

            land = new int[column][row];
            visited = new int[column][row];
            for (int y = 0; y < num; y++) {
                int c = sc.nextInt();
                int r = sc.nextInt();
                land[c][r] = 1;
            }

            int count = 0;
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (visited[i][j] == 1 || land[i][j] == 0) continue;
                    dfs(i, j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int i, int j) {

        Pair pair = new Pair(i, j);
        for (int z = 0; z < 4; z++){
            int d_x = pair.x + dx[z];
            int d_y = pair.y + dy[z];

            if(d_x < 0 || d_y < 0 || d_x >= column || d_y >= row) continue;
            if (visited[d_x][d_y] == 1 || land[d_x][d_y] == 0) continue;
            visited[d_x][d_y] = 1;
            dfs(d_x, d_y);
        }
    }


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
