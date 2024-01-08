import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, arr, m));
    }


    /* 마구간 정하기
     *  좌표가 중복되는 일은 없다
     *  C마리의 말, 가까이 있는 것을 좋아핮히 않음, 마구간에는 한 마리만 들어갈 수 있음
     *  가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치
     *  */
    public int solution(int n, int[] input, int m) {
        Arrays.sort(input);
        int answer = 0;
        int lt = 1;
        int rt = input[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            // 조건문의 의미 : 해당 범위에서 목표로 하는 말을 전부 마구간에 넣을 수 있는지
            if (count(input, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    // dist : mid값
    public int count(int[] arr, int dist) {
        int cnt = 1;
        // 시작 좌표
        int ep = arr[0];
        // 시작 다음부터 하나씩 넣어서
        for (int i = 1; i < arr.length; i++) {
            // dist보다 같거나 커야지 말을 배치할 수 있다.
            // 상식적으로 범위보다 작은 상태에서 말을 배치하기는 힘들다,
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }
}

