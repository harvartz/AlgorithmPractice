import java.io.*;
import java.util.*;

class Main {

    static boolean[][] map;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }
        // 모든 체스판을 검색

        int N_row = N - 7;
        int M_col = M - 7;
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    static void find(int x, int y) {

        // 1. 탐색 좌표로부터 8을 더해서 끝날 좌표까지 범위를 구함
        int range_x = x + 8;
        int range_y = y + 8;
        int count = 0;

        // 2. 범위 안에 올바른 색이 아니면 count
        boolean check = map[x][y];
        for (int i = x; i < range_x; i++) {
            for (int j = y; j < range_y; j++) {
                if (check != map[i][j]) {
                    count++;
                }
                check = !check;
            }
            check = !check;
        }
        /* 첫번째 칸을 기준으로 할 떄의 색칠 할 개수(count)
           첫번쨰 칸의 색의 반대되는 색을 기준으로 할 때의
           색칠 할 개수(64-count) 중 최솟값을 count에 저장
        */
        count = Math.min(count, 64 - count); // count: 현재 비교하는 색 바뀐 수, count -64: 비교하지 않은 색일 떄의 잘못된 칸의 갯수
        // 3. 줄이 바뀌면 비교
        /*
         * 이전까지의 경우 중 최솟값보다 현재 count 값이
         * 더 작을 경우 최솟값을 갱신*/
        min = Math.min(min, count);
    }
}