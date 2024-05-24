import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Main {
    /*
     * 11659 : 구간 합 구하기4
     * https://www.acmicpc.net/problem/11659*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int x = 1; x <= N; x++) {
            arr[0] = 0;
            arr[x] = arr[x - 1] + Integer.parseInt(st.nextToken());
        }

        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(arr[end] - arr[start - 1]);
        }
    }
}

