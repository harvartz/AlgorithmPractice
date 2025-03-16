import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int n;
    static boolean[][] am = new boolean[102][102];
    static boolean[] vis = new boolean[102];

    static boolean dfs(int st, int tar) {
        for (int i = 0; i <= n + 1; i++) {
            vis[i] = false;
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(st);

        while (!stk.empty()) {
            int cur = stk.pop();

            if (vis[cur]) continue;
            if (cur != st) vis[cur] = true;

            for (int nxt = 0; nxt < n; nxt++) {
                if (vis[nxt]) continue;
                if (am[cur][nxt]) {
                    if (nxt == tar) return true;
                    stk.push(nxt);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                am[i][j] = (val == 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((dfs(i, j) ? "1 " : "0 "));
            }
            System.out.println();
        }
    }
}
