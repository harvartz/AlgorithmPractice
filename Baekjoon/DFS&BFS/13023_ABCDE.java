import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    /*
     * 13023_ABCDE
     * 구현 자체는 쉽지만 문제를 해석하지 못해서 풀지 못했던 문제
     * 이 문제는 주어진 그래프에서 길이가 정확히 5인 경로가 존재하는지를 확인하는 문제이다.
     * 즉, 임의의 노드에서 시작하여 깊이 5에 도달할 수 있는 경로가 있는지 확인하면 된다.
     * */
    static int m;
    static ArrayList<ArrayList<Integer>> list;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        m = M;

        list = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        for (int i = 0; i < N; i++) {
            if (answer != 1) dfs(i, 1);
        }

        System.out.println(answer);
    }

    static void dfs(int start, int level) {
        if (level == 5) {
            answer = 1;
            return;
        }
        visited[start] = true;
        for (int x : list.get(start)) {
            if (!visited[x]) {
                dfs(x, level + 1);
            }
        }
        visited[start] = false;
    }
}
