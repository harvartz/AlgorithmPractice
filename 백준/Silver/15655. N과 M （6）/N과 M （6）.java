import java.io.*;
import java.util.*;

public class Main {

    // N과 M (4)
    // 중복조합
    // 비내림차순 - 오름차순 -> 그냥 점차 상승해야 한다.

    static int N, M;
    static int[] a, b;
    //static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void perm(int now, int level) {
        if (level == M) {
            for (int i = 0; i < M; i++) {
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = now; i < N; i++) {
            //if(visited[i]) continue;
            //visited[i] = true;
            b[level] = a[i];
            perm(i + 1, level + 1);
            //visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[M];
        //visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        perm(0, 0);
        System.out.print(sb);
    }
}