import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다시 풀어봤으면 좋겠다
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

    /* 결정 알고리즘?
     * - 정렬되어 있어야지 가능함
     * - 답이 될 수 있는 범위를 미리 지정하고 찾는 방식
     * - 다음으로는 이분탐색으로 정해진 범위내에서 좁혀 나가면 된다*/
    public int solution(int n, int[] input, int m) {
        int answer = 0;
        int lt = Arrays.stream(input).max().getAsInt(); // 자바의 Iterator라고 생각하셈 - Reduction 함수 - for문을 사용하지 않고 이렇게 진행할 수 있음
        int rt = Arrays.stream(input).sum();

        // 이분탐색을 계속 진행하다보면 lt가 rt를 넘어가는 경우가 생긴다.
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            // 목표한 DVD양보다 작거나 같은 경우는 범위를 줄인다.
            // DVD를 많이 사용한다는 뜻은 어떤 의미인가?
            // 해당 범위에 담을 수 있다는 뜻은 DVD에 목표한 최소한의 DVD용량을 채울 수 있다는 뜻이다
            if (count(input, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }

    public int count(int[] arr, int capacity) {
        // DVD 장 수, 한장 DVD의 전체 용량
        int cnt = 1, sum = 0;
        for (int x : arr) {
            // 목표하고자하는 용량보다 더해지는 용량이 커진다고 하면
            if (sum + x > capacity) {
                cnt++;
                // 새로운 DVD 첫번째 값을 넣는다.
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}

