import java.awt.*;
import java.io.*;
import java.util.*;

class Main {
    /*
     * 18232_텔레포트 정거장
     * https://www.acmicpc.net/problem/18232 */
    static int N, M, S, E;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = Integer.MAX_VALUE;
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for (int x = 0; x <= N; x++) {
            map.add(new ArrayList<>());
        }

        // 1부터 5까지 차례대로 연결되어 있는 점
        for (int x = 2; x <= N; x++) {
            map.get(x - 1).add(x);
            map.get(x).add(x - 1);
        }

        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        bfs(S, E);

        System.out.println(dist[E]);
    }

    static void bfs(int now, int end) {
        qu.add(now);
        visited[now] = true; // while 반복문에 들어가면 처음이 방문처리가 되지 않기 때문에 여기에서 방문처리를 해준다.

        while (!qu.isEmpty()) {
            int temp = qu.poll();

            for (int i : map.get(temp)) {
                if (!visited[i]) {
                    dist[i] = dist[temp] + 1;
                    visited[i] = true;
                    qu.offer(i);
                    if (i == end) {
                        return;
                    }
                }
            }
        }
    }
}