import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[] answer = new int[2];
        if (k > c * r) System.out.println(0 + " " + 0);
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while (count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        System.out.println(Arrays.toString(answer));
    }
}
