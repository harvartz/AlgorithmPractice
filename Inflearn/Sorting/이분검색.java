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

    // 이분 탐색 구현해보기
    public int solution(int n, int[] input, int m) {
        int result = 0;
        Arrays.sort(input);

        /* 중간을 비교하여 크고 작음에 따라서 범위를 다시 정한다. */
        int start = 0;
        int end = n;

        // while문의 조건이 왜 이렇게 될까?
        // 검색의 범위가 줄어들면서 start가 end보다 같거나 크다는 뜻은 더이상 검색할 범위가 없다는 뜻이다
        while (start <= end) {
            int mid = (start + end) / 2;
            if (input[mid] == m) {
                result = mid + 1;
                break;
            }
            if (input[mid] > m) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }
}

