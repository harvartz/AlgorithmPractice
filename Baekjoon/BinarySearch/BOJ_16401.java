import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] cookies = new int[N];

        int max = 0;
        for (int x = 0; x < N; x++) {
            cookies[x] = sc.nextInt();
            max = Math.max(max, cookies[x]);
        }

        int left = 1;
        int right = max;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int x = 0; x < cookies.length; x++) {
                cnt += cookies[x] / mid;
            }
            if (cnt >= M) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}