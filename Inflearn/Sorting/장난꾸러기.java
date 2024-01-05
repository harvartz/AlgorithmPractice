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
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    /* 1. 철수는 짝꿍보다 키가 크다.
     *  2. 앞 번호를 바꾸고 싶어서 짝궁과 자리를 바꿨다.
     *  정렫되어 있는 배열 하나, 바뀐 배열 하나를 비교해서 다른 두 개의 인덱스를 기억해서
     *  값이 큰 것이 철수로 배정하면 되지 않나*/

    public ArrayList<Integer> solution(int n, int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        /* 배열 복사할 때 메소드
         * 1. arraycopy(원본 배열, 워본 배열의 복사 시작 지점, 복사할 배열, 복사할 배열의 복사 시작 지점, 복사할 요소의 개수
         * 2. copyOf(원본 배열, 원본배열에서 복사해올 길이)
         * 3. clone() 메소드도 있다
         * 1,2번은 길이 범위를 커스텀할 수 있고 간단한건 3번이다*/
        int[] previous = new int[n];
        System.arraycopy(input, 0, previous, 0, n);
        Arrays.sort(input);

        for (int x = 0; x < n; x++) {
            int pos = -1;
            if (previous[x] != input[x]) {
                result.add(x + 1);
            }
        }
        return result;
    }
}
