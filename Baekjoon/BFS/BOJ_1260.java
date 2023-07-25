import java.util.*;

/*
* DFS와 BFS
* */
public class BOJ_1260 {

    static List<List<Integer>> graph;
    static int n;
    static int m;
    static int v;
    static boolean[] visited;
    static int[] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        graph = new ArrayList<>();
        for (int x = 0; x < n + 1; x++) {
            graph.add(new ArrayList<>());
        }

        for (int x = 0; x < m; x++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int x = 0; x < n + 1; x++) {
            Collections.sort(graph.get(x));
        }

        visited = new boolean[n + 1];
        checked = new int[n + 1];
        dfs(v);

        Arrays.fill(visited, false);
        Arrays.fill(checked, 0);

        System.out.print("\n");
        bfs(v);
    }

    static void dfs(int curr) {
        visited[curr] = true;

        // 1을 읽지 못해서
        System.out.print(curr + " ");
        for (int x : graph.get(curr)) {
            if (visited[x]) continue;
            dfs(x);
        }
    }

    static void bfs(int curr) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(curr);

        while (!qu.isEmpty()) {
            int result = qu.poll();

            if (visited[result]) continue;

            System.out.print(result + " ");
            visited[result] = true;
            for (int y : graph.get(result)) {
                qu.add(y);
            }
        }
    }
}
