import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int days = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int[] arr = new int[days];

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < days; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(days, max, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer, sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        answer = sum;
        /* 슬라이딩 윈도우 기법
         * 3씩 밀면서 탐색하는 기법
         * 어떻게 구현하는지 한번 생각해보기
         * */
        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i - m]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}