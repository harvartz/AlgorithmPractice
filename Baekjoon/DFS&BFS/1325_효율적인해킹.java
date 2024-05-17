import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] count; // 회사에 몇번 방문했는지 확인하는 변수
    static int[] visited; // 해당 회사를 방문했는지 안했는지 확인하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int x = 0; x <= N; x++) {
            arr.add(new ArrayList<>());
        }

        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);// 단방향 그래프이기 때문에 한번만 해준다.
        }
        count = new int[N + 1];
        int max = -1; // 최대 값을 찾아내기 위한 변수

        for (int x = 1; x <= N; x++) {
            visited = new int[N + 1]; // 그래프 전체를 탐색
            dfs(x);
        }
        for (int x = 1; x <= N; x++) { // 최대값을 찾아내기 위한 로직
            if (max < count[x]) max = count[x];
        }

        for (int x = 1; x <= N; x++) { // 출력 로직
            if (max == count[x]) System.out.print(x + " ");
        }
    }

    public static void dfs(int start) {
        visited[start] = 1;

        // 방문한 회사를 기점으로 신뢰(연결)되어 있는 회사를 찾는다.
        for (int next : arr.get(start)) {
            if (visited[next] == 1) continue; // 방문했다면 넘어가고 (무한 순회를 방지한다)
            count[next]++; // 기점으로 삼은 회사의 방문 횟수를 늘린다
            dfs(next);
        }
    }
}
