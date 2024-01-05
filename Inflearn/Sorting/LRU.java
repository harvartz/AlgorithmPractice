import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }
        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }

    public int[] solution(int s, int n, int[] input) {
        int[] result = new int[s];

        for (int x = 0; x < n; x++) {
            // 입력받은 값이 배열에 있을 때 해당 인덱스의 위치를 담기 위한 변수
            int pos = -1;
            // 있으면 pos에 현재 위치 인덱스 값을 할당
            for (int y = 0; y < s; y++) if (input[x] == result[y]) pos = y;
            // 없을 경우
            if (pos == -1) {
                // 하나씩 뒤로 땡겨서 맨 앞에 새로운 숫자를 삽입한다. => 삽입 정렬 사용
                for (int i = s - 1; i >= 1; i--) {
                    result[i] = result[i - 1];
                }
                // 맨 앞에 값을 두는 코드
                result[0] = input[x];
            } else {
                // pos의 값을 맨 앞에다 가져올 때 삽입 정렬을 사용하여 가져옴
                for (int i = pos; i >= 1; i--) {
                    result[i] = result[i - 1];
                }
                result[0] = input[x];
            }
        }
        return result;
    }

    /* 각 경우의 수 마다 내가 어떤 규칙을 만들어서 분류할지 먼저 생각해야 한다*/
}