import java.io.*;
import java.util.*;

class Main {
    /*
     * 문제: 나이순 정렬
     * 해결 방법: 정렬을 사용하여 푼다
     * 1. Arrays.sort(arr, (o1, o2) -> {Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]))})
     * - Integer.compare -> 두 정수를 비교하여 -1, 0, 1중 하나를 반환
     * - 아래의 방법은 매우 큰 정수 값을 다룰 때는 오버 플로우가 발생할 수 있다. 이 부분이 더 안전하다.
     * 2. Arrays.sort(users, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
     * - 두 정수의 차이를 반환
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        Arrays.sort(arr, (o1, o2) -> {
            // 클래스를 만들어도 되지만 이렇게 바로 형변환을 하면 메모리를 절약하면서 풀 수 있다.
            return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        });

        StringBuilder sb = new StringBuilder();
        for (String[] user : arr) {
            sb.append(user[0]).append(" ").append(user[1]).append("\n");
        }
        System.out.print(sb);
    }
}