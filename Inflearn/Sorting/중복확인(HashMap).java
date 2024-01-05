import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, arr));
    }

    public String solution(int n, int[] input) {
        String answer = "U";
        // 정렬을 해서 앞 뒤의 문자가 같은 경우가 있으면 D, U
        Arrays.sort(input);

        HashMap<Integer, Integer> result = new HashMap<>();

        for (int x = 0; x < n; x++) {
            result.put(input[x], result.getOrDefault(input[x], 0) + 1);

            if (result.get(input[x]) > 1) {
                answer = "D";
                break;
            }
        }

        return answer;
    }
    /* 1. HashMap을 사용해서 풀면 O(N)으로 풀 수 있음
        - 이미 같은 키 값을 하나 더하려고 할 때 break를 걸고 return 하면 된다
    *  2. 정렬을 사용해서 풀면 O(N log(N))으로 풀 수 있음*/
}
