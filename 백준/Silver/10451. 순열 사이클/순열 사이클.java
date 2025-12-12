import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] brr;
    static boolean[] visited;

    public static void perm(int now) {

        if (!visited[now]) {
            visited[now] = true;
            perm(brr[now] - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            brr = new int[N];
            visited = new boolean[N];
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    perm(brr[i] - 1);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
