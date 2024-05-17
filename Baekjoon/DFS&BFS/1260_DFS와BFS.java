import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] visted;
    static Queue<Integer> qu = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int x = 0; x <= n; x++) {
            arr.add(new ArrayList<>());
        }

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(arr.get(i));
        }
        visted = new int[n + 1];
        dfs(v);
        System.out.println();
        visted = new int[n + 1];
        bfs(v);
    }

    public static void dfs(int start) {
        if (visted[start] == 1) return;
        visted[start] = 1;

        System.out.print(start + " ");
        for (int x : arr.get(start)) {
            if (visted[x] == 1) continue;
            dfs(x);
        }
    }

    public static void bfs(int start) {
        qu.offer(start);
        visted[start] = 1;

        while (!qu.isEmpty()) {
            int temp = qu.poll();
            System.out.print(temp + " ");

            for (int x : arr.get(temp)) {
                if (visted[x] == 1) continue;
                visted[x] = 1;
                qu.offer(x);
            }
        }
    }
}
