import java.util.*;

public class BOJ_11047{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int x = 0; x < n; x++) {
            arr[x] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);
        int count = 0;
        for (int x = n-1; x >= 0; x--) {
            count += k / arr[x];
            k %= arr[x];
        }
        System.out.println(count);
    }
}