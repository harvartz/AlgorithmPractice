import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] a;
    static int[] b;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        recur(0);

    }

    static void recur(int level) {
        if (level == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
            return;
        }
        int before = 0;
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            if (before != a[i]) {
                v[i] = true;
                b[level] = a[i];
                before = a[i];
                recur(level + 1);
                v[i] = false;
            }
        }
    }
}
