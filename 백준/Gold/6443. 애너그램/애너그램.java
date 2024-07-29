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
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == length) {
            sb.append(b).append("\n");
            return;
        }
        // 계속 초기화를 하기 때문에 처음에 반복문을 돌 때는 상관이 없다.
        // 하지만 첫 return이 되고 나서부터는 값이 이전에 갱신된 값과 비교하게 된다.
        // ex) depth
        // 즉, 한번은 요소 중복을 허용하게 되고 이후부터는 if(before != a[i]) 조건문을 통해 요소의 중복을 방지할 수 있다.
        // aabc - aabc (X), aabc (O)
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