import java.io.*;
import java.util.*;

class Main {
    /*
     * 2668_숫자고르기!
     * https://www.acmicpc.net/problem/2668
     * 1. 그래프를 입력 받고
     * 2. 순회하는 그래프를 탐색
     * 3. 첫번째 탐색지점과 마지막 탐색 지점이 동일한 경우 순회로 봄 -> 리스트에 값 저장
     * */
    static int[] arr;
    static int N, num;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; // 입력 받은 숫자를 저장할 배열
        check = new boolean[N + 1]; // 입력 받은 숫자가 방문여부를 저장하는 배열
        for (int x = 1; x <= N; x++) {
            int input = Integer.parseInt(br.readLine());
            arr[x] = input;
        }

        for (int x = 1; x <= N; x++) { // 최대 값을 구하기 위해서 N번 반복한다
            check[x] = true;
            num = x;
            dfs(x);
            check[x] = false; // 다른 싸이클을 돌기 전에 방문 해제 -> 해제하지 않는다면 가능한 모든 경로를 찾을 수 없다
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.println(x);
        }
    }

    static void dfs(int now) {
        if (arr[now] == num) { // 첫번째 표의 값이 두번째와 일치하는가? => 순회하는가?
            result.add(num);
        }
        if (!check[arr[now]]) { // 아직 방문하지 않았다면
            check[arr[now]] = true; // 방문 처리하고
            dfs(arr[now]); // 다시 dfs 순회
            check[arr[now]] = false; // 끝나고 나면 방문 해제
        }
    }
}
