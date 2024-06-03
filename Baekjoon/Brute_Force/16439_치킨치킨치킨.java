import java.io.*;
import java.util.*;

class Main {
    /*
     * 16439_치킨치킨치킨
     * https://www.acmicpc.net/problem/16439
     * 문제를 이해하는데 시간이 오래걸렸다
     * 백트랙킹을 활용하여 문제를 풀어보자.
     * */
    static int N, M;
    static int[][] map;
    static boolean[] check; // 치킨이 선택되었는지 확인하는 배열
    static int result = 0; // 답을 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[M];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                map[x][y] = Integer.parseInt(st.nextToken()); // 1차 인덱스는 사람, 2차 인덱스는 사람에 대한 치킨 선호도
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        if (depth == 3) { // 3인 이유는 최대 종류가 3개이기 때문이다.
            int sum = 0;
            for (int i = 0; i < N; i++) { // N명의 사람을 차례대로 순회한다.
                int temp = 0; // 최대값을 구하기 위한 임시 변수
                for (int j = 0; j < M; j++) {
                    if (check[j]) { // check가 true로 되어있는 치킨만 진행한다.
                        temp = Math.max(temp, map[i][j]); // 해당 사람에서 선호도가 가장 높은 것을 고른다
                    }
                }
                sum += temp; // 위의 최대 값을 전체 값에 더한다.
            }
            result = Math.max(sum, result); // 여러 종류의 총합이 나올 텐데, 그 중에서 가장 큰 값을 저장한다.
            return;
        }

        for (int i = start; i < M; i++) { // 매개변수 start를 반복문 초기값으로 잡는다. 왜? 넘어오기 전에 start - 1을 방문처리 했기 때문에 그 이후부터 탐색해야 하기 때문이다.
            if (!check[i]) {
                check[i] = true; // 방문 처리
                dfs(depth + 1, start + 1); // + 1을 해주는 이유도 마찬가지로 다음 인덱스를 탐색해야 하기 때문에 1을 더해준다.
                check[i] = false; // 방문 해제
            }
        }
    }
}
