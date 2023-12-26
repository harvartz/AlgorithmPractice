import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] brr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < m; x++) {
            brr[x] = Integer.parseInt(st.nextToken());
        }

        for (int x : T.solution(n, m, arr, brr)) {
            System.out.print(x + " ");
        }
    }

    public static ArrayList<Integer> solution(int n, int m, int[] arr, int[] brr) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(brr);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr[p1] == brr[p2]) {
                answer.add(arr[p1++]);
                p2++;
            } else if (arr[p1] < brr[p2]) p1++;
            else p2++;
        }
        return answer;
    }
}