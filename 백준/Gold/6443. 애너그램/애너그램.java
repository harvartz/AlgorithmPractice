import java.io.*;
import java.util.*;

class Main {

    static char[] a;
    static char[] b;
    static boolean[] v;
    static int length;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            a = br.readLine().toCharArray();
            length = a.length;
            b = new char[length];
            v = new boolean[length];
            Arrays.sort(a);
            dfs(0);
        }

        // 전체 결과를 한 번에 출력합니다.
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == length) {
            sb.append(b).append("\n");
            return;
        }
        char before = ' ';
        for (int i = 0; i < length; i++) {
            if (v[i]) continue;
            if (before != a[i]) {
                v[i] = true;
                b[depth] = a[i];
                before = a[i];
                dfs(depth + 1);
                v[i] = false;
            }
        }
    }
}
