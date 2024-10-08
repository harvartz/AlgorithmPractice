import java.io.*;
import java.util.*;

class Main {
    static int[][] map = new int[10][10];
    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, 1, 0, -1};
    static int time = 0;
    static int dogDirection = 0;
    static int hyunsuDirection = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 현수와 강아지의 현재 위치
        int[] dogLocation = new int[2];
        int[] hyunsuLocation = new int[2];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 처음 위치를 찾아서 넣어준다.
                if (map[i][j] == 2) {
                    hyunsuLocation[0] = i;
                    hyunsuLocation[1] = j;
                } else if (map[i][j] == 3) {
                    dogLocation[0] = i;
                    dogLocation[1] = j;
                }
            }
        }
        int hx = 0, hy = 0, dx = 0, dy = 0;
        // 10000분 이후가 넘어가면 그냥 0을 return 해준다.
        while (time < 10000) {
            // 현수 다음 움직임
            hx = hyunsuLocation[0] + mx[hyunsuDirection];
            hy = hyunsuLocation[1] + my[hyunsuDirection];
            // 강아지 다음 움직임
            dx = dogLocation[0] + mx[dogDirection];
            dy = dogLocation[1] + my[dogDirection];

            // 움직임과 동시에 시간은 흘러 간다.
            time++;
            if (isPossible(hx, hy)) { // 다음 움직임은 가능한 움직임이다 == 방향을 틀지 않아도 된다.
                hyunsuLocation[0] = hx;
                hyunsuLocation[1] = hy;
            } else { // 그렇지 않으면 방향을 움직인다. 시간을 따로 조정하지 않는 이유는 어처피 위에서 한번에 처리하기 때문이다.
                hyunsuDirection = (hyunsuDirection + 1) % 4;
            }
            if (isPossible(dx, dy)) {
                dogLocation[0] = dx;
                dogLocation[1] = dy;
            } else {
                dogDirection = (dogDirection + 1) % 4;
            }

            if (hx == dx && hy == dy) break;
        }
        System.out.println("time: " + time);
        if (time > 10000) {
            System.out.println(0);
            return;
        }
    }

    static public boolean isPossible(int x, int y) {
        // 맵 바깥으로 벗어나거나 나무를 만날 때
        if (x < 0 || x >= 10 || y < 0 || y >= 10 || map[x][y] == 1) {
            return false;
        }
        return true;
    }
}
