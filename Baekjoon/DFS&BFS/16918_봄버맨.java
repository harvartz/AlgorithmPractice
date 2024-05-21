import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {

    /*
     * 16918_봄버맨
     * https://www.acmicpc.net/problem/16918
     * */
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static char map[][];
    static int[] d_x = {-1, 0, 1, 0};
    static int[] d_y = {0, -1, 0, 1};
    static Queue<Pair> qu;
    static int R, C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        qu = new LinkedList<>();

        for (int q = 0; q < R; q++) {
            String input = br.readLine();
            for (int w = 0; w < C; w++) {
                map[q][w] = input.charAt(w);
                if (map[q][w] == 'O') {
                    qu.offer(new Pair(q, w)); // 초기값 폭탄의 위치를 qu에 집어 넣는다.
                }
            }
        }

        for (int g = 2; g <= N; g++) { // 1초에는 변화가 없기 때문에 2초부터 N초까지 진행한다.
            if (g % 2 == 0) { // 시간이 짝수이면 '.' 공간에 폭탄 채워넣기
                for (int x = 0; x < R; x++) { // 격자판을 탐색한다.
                    for (int y = 0; y < C; y++) {
                        if (map[x][y] == '.') { // 격자판에서 빈공간이면 폭탄을 채워넣는다.
                            map[x][y] = 'O';
                        } else if (map[x][y] == 'O') { // 'O' 폭탄이 있다면 큐에 넣어서 홀수 초에 터트린다.
                            qu.offer(new Pair(x, y));
                        }
                    }
                }
            } else { // 홀수이면 터트리기
                bfs();
            }
        }

        for (int q = 0; q < R; q++) {
            for (int w = 0; w < C; w++) {
                System.out.print(map[q][w]);
            }
            System.out.println();
        }
    }

    public static void bfs() {
        while (!qu.isEmpty()) { // 같은 시점에 생긴 폭탄이 끝날때까지 계속 진행한다.
            Pair p = qu.poll();
            map[p.x][p.y] = '.'; // 기준점이 되는 위치를 초기화 해줘야 한다 -> 이곳을 못찾았었음
            for (int i = 0; i < 4; i++) { // 4방 탐색
                int dx = p.x + d_x[i];
                int dy = p.y + d_y[i];

                if (dx >= 0 && dy >= 0 && dx < R && dy < C) { // 격자판 안에 있는 경우, 다른 조건 없이 탐색 좌표를 폭탄으로 바꿔준다.
                    map[dx][dy] = '.';
                }
            }
        }
    }
}
