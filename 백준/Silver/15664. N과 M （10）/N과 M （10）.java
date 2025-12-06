import java.io.*;
import java.util.*;

public class Main {

    // N과 M (9)
    // 배열 안에 같은 숫자가 있을 때 어떻게 해야하는가?
    // Set을 사용해서 중복을 제거하는 경우가 있을 것이고
    // 1, 1, 2, 3일때 1,1을 어떻게 구분하는가?
    // 배열에서 중복을 제거해야 하는가? 어떻게?

    static int N, M;
    static int[] a, b;
    static boolean[] visited;
    static int before;
    static StringBuilder sb = new StringBuilder();

    static void perm(int now, int level) {
        if (level == M) {
            for (int i = 0; i < M; i++) {
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 
        int before = 0;
        for (int i = now; i < N; i++) {
            //if (visited[i]) continue;
            // 정렬이 되어 있기 때문에 전과 후가 다른지만 확인하면 된다.
            if (before == a[i])
                continue;
            before = a[i];
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
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        perm(0, 0);
        System.out.print(sb);
    }
}