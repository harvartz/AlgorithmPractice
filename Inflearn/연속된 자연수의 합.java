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

        System.out.println(T.solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        // 배열에 그냥 1씩 추가해서 했다. 너무 선언한 변수를 활용하려고 하지 말자
        int[] arr = new int[n];
        for (int x = 0; x < n; x++) arr[x] = x + 1;
        // n / 2+1 을 해주는 이유는 이상으로 넘어 갔을 때 연속된 자연수의 합이 무조건 15가 넘어가기 때문이다.
        // 이 부분을 놓쳤다.
        for (int rt = 0; rt < n / 2 + 1; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }
        return answer;
    }
}