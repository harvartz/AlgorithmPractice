import java.io.*;
import java.util.*;

class Main {
    /*
     * 14249_점프점프
     * https://www.acmicpc.net/problem/14248*/

    static int[] bridge;
    static int n;
    static int count = 1; // 처음 방문한 칸을 count 해야하기 때문에 1로 시작한다.
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bridge = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 1; x <= n; x++) {
            bridge[x] = Integer.parseInt(st.nextToken());
        }

        int now = Integer.parseInt(br.readLine());
        visited[now] = true;
        dfs(now);

        System.out.println(count);
    }

    static void dfs(int now) {

        int left = now - bridge[now]; // 왼쪽으로 가기
        int right = now + bridge[now]; // 오른쪽으로 가기
        if (left > 0 && !visited[left]) { //왼쪽으로 가니깐 조건식을 하나만 넣으면 된다.
            visited[left] = true; // 방문 처리
            count++;
            dfs(left);
        }
        if (right <= n && !visited[right]) { //오른쪽으로 가니깐 조건식을 하나만 넣으면 된다.
            visited[right] = true;
            count++;
            dfs(right);
        }

    }
}