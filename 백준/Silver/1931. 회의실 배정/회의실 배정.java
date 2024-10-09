import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]); // 끝나는 시간이 같으면 시작 시간이 빠른 것을 먼저
            }
            return Integer.compare(o1[1], o2[1]); // 끝나는 시간을 오름 차순으로 정렬한다.
        });

        int count = 1;
        int endTime = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (endTime <= arr[i][0]) {
                endTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}