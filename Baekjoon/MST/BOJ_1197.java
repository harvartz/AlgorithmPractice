import java.io.*;
import java.util.*;

class Main {

    /*
     * 최소신장트리: https://www.acmicpc.net/problem/1197*/

    static int V;
    static int E;
    static int[][] g = new int[V][3];
    static int[] p;

    static void make() {
        p = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }
    }

    static int find(int i) {
        if (p[i] == i)
            return i;
        else
            return p[i] = find(p[i]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;
        if (aRoot < bRoot) {
            p[bRoot] = aRoot;
        } else
            p[aRoot] = bRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        g = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(sc.nextLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            g[i] = new int[]{from, to, cost};
        }

        // 먼저 제대로 들어왔는지 확인하기
//		for (int i = 0; i < V; i++) {
//			System.out.println(Arrays.toString(g[i]));
//		}

        // 2. sort 해야지
        Arrays.sort(g, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 3. 하나씩 union 되는지 확인하고 되면 더하기
        int sum = 0;
        int cnt = 0;

        make();
        for (int i = 0; i < E; i++) {
            if (union(g[i][0], g[i][1])) {
                sum += g[i][2];
                if (++cnt == V - 1) {
                    System.out.println(sum);
                    return;
                }
            }
        }
        sc.close();
    }
}