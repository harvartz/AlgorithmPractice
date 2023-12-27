import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        System.out.println(T.solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        // 실제로 배열을 바꾸는 것이 아니라 바꾼 횟수의 변화로 확인한다.
        int count = 0;
        int answer = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            // rt를 움직이면서 0을 만나면 cnt를 추가해서 1로 바꿔줬다고 상태 변화를 준다.
            if (arr[rt] == 0) {
                count++;
            }
            // 만약 바꾼 횟수가 제한을 넘어갔을 경우
            while (count > m) {
                // lt를 움직여서 0을 만나면 count를 줄여서 다시 바꿔준다,
                if (arr[lt] == 0) count--;
                lt++;
            }
            // rt - lt + 1은 연속된 1의 길이를 의미한다.
            answer = Math.max(answer, rt - lt + 1);

        }
        return answer;
    }
}