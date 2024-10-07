import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int k;
    static int[] answer = new int[2];
    static int time = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0;
        int y = 0;
        int d = 0;

        while (time < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 이동한 좌표가 map 안에 있는 경우이면서 장애물이 없는 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
                // 이동한 좌표를 다음 좌표로 넣어준다.
                x = nx;
                y = ny;
                time++; // 이동 성공 시에만 시간 증가
            } else { // 이동한 좌표가 map 밖으로 벗어나거나 장애물을 만나는 경우
                //
                time++;
                d = (d + 1) % 4; // 이동이 불가하면 방향만 전환
            }
        }

        answer[0] = x;
        answer[1] = y;
        System.out.println(Arrays.toString(answer));
    }
}
