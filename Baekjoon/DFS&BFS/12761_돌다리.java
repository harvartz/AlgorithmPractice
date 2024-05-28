import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 12761_돌다리
     * https://www.acmicpc.net/problem/12761 */
    static int N, M, A, B;
    static boolean[] visited = new boolean[100001];
    static int[] map = new int[100001];


    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bfs(N, M);

        System.out.println(map[M]);
    }

    static void bfs(int start, int end) {
        qu.offer(start);
        visited[start] = true;

        while (!qu.isEmpty()) {
            int temp = qu.poll();
            // 여기가 핵심 -> 현재지점에서 갈 수 있는 방향의 값을 모두 배열로 만든 다음에 탐색에 들어간다.
            int[] move = new int[]{temp - 1, temp + 1, temp + A, temp - A, temp + B, temp - B, temp * A, temp * B};
            for (int i = 0; i < 8; i++) {
                if (move[i] <= 100000 && move[i] >= 0 && !visited[move[i]]) {
                    visited[move[i]] = true;
                    map[move[i]] = map[temp] + 1;
                    qu.offer(move[i]);
                }
            }
            if (map[end] > 0) break; // 찾으려고 하는 자리에 숫자가 갱신되면 탐색을 종료한다.
        }
    }
}