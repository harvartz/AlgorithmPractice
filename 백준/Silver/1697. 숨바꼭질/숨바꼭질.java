import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static Queue<Integer> qu = new LinkedList();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        qu.offer(N);

        int level = 0;
        while (!qu.isEmpty()) {
            int length = qu.size();
            for (int i = 0; i < length; i++) {
                int now = qu.poll();
                visited[now] = true;

                if (now == K) {
                    System.out.println(level);
                    return;
                }

                int[] move = { now + 1, now - 1, now * 2 };

                for (int j = 0; j < 3; j++) {
                    if (move[j] < 0 || move[j] > 100000)
                        continue;
                    if (visited[move[j]])
                        continue;
                    visited[move[j]] = true;
                    qu.offer(move[j]);
                }
            }
            level++;
        }
    }
}