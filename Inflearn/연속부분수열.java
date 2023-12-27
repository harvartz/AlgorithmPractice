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

        int count = 0;
        int sum = 0;
        int lt = 0;
        /* 1. 포인터 이동
           2. 더하고
           3. 비교한다
           위의 세 개의 루틴이 항상 실행되어야 한다.
        * */
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                count++;
            }
            // 왜 else if로 되지 않았는가?
            // 1 1 1 1 6 인경우 한번만 lt를 빼서 해결되는 것이 아니라 계속해서 뺄 수
            // 있기 때문이다
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) count++;
            }
        }
        return count;
    }
}