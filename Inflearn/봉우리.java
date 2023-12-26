import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(arr, n));
    }


    public int solution(int[][] arr, int n) {
        int count = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                boolean flag = true;
                for (int z = 0; z < 4; z++) {
                    int d_x = x + dx[z];
                    int d_y = y + dy[z];
                    if (d_x < 0 || d_y < 0 || d_x >= n || d_y >= n) continue;
                    // 항상 생각을 뒤집어서도 진행해보자
                    // 주위에 하나라도 크다면 해당 수는 봉우리가 아니기 때문에 바로 탈출한다.
                    // 최대한 반복문을 빠르게 탈출할 수 있는 경우를 생각해보면 조금 더 생각하지 편하지 않을까 싶다.
                    if (arr[d_x][d_y] >= arr[x][y]) {
                        flag = false;
                        break;
                    }
                }
                // 여기에서 count를 해야 하는데

                if (flag == true) count++;
            }
        }
        return count;
    }
}