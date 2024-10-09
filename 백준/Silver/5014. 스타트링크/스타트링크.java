import java.io.*;
import java.util.*;

class Main {

    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] move;
    static int[] count;
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 현재 위치
        G = Integer.parseInt(st.nextToken()); // 목표 층수
        U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
        D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동

        visited = new boolean[F + 1];
        count = new int[F + 1];
        move = new int[]{-D, U};
        // System.out.println("아래층: " + -D + ", 윗층: " + U + ", 목표 층 : " + G);
        bfs();
        // dfs(S, 0);
    }

    static public void bfs() {
        qu.offer(S);
        visited[S] = true; // 시작점 방문 처리

        while (!qu.isEmpty()) {
            int now = qu.poll();

            if (now == G) {
                System.out.println(count[now]);
                return; // 목표층 도착 시 종료
            }

            for (int i = 0; i < 2; i++) {
                int nextMove = now + move[i];
                if (nextMove > F || nextMove < 1) continue;
                if (0 < nextMove && nextMove <= F && !visited[nextMove]) {
                    visited[nextMove] = true;
                    count[nextMove] = count[now] + 1; // 이동 횟수 저장
                    qu.offer(nextMove);
                }
            }
        }
        System.out.println("use the stairs");
    }

    static public void dfs(int now, int count) {
        if (now == G) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nextMove = now + move[i];
            if (0 < nextMove && nextMove < F) {
                dfs(nextMove, count + 1);
            } else {
                return;
            }
        }
    }
}
