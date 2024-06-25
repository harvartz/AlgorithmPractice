import java.io.*;
import java.util.*;

class Main {

    /*
     * 11000_강의실배정
     * https://www.acmicpc.net/problem/11000 */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 최소로 강의실을 사용하게 하려면 어떻게 해야할까?
        Arrays.sort(arr, ((s1, s2) -> {
            if (s1[0] == s2[0]) {
                return Integer.compare(s1[1], s2[1]);
            }
            return Integer.compare(s1[0], s2[0]);
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}