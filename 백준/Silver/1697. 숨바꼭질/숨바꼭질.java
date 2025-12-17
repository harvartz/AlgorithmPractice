import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<>();
        visited = new int[100001];

        qu.offer(n);
        int level = 0;
        while (!qu.isEmpty()) {
            int len = qu.size();
            for (int i = 0; i < len; i++) {
                int result = qu.poll();
                int[] move = {result - 1, result + 1, result * 2};
                visited[result] = 1;

                if (result == m) {
                    System.out.println(level);
                    return;
                }

                for (int x = 0; x < move.length; x++) {
                    if (move[x] < 0 || move[x] > 100000) continue;
                    if (visited[move[x]] == 1) continue;
                    qu.offer(move[x]);
                }
            }
            level++;
        }
    }
}
