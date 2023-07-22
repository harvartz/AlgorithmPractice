import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920 {

    static int[] a;
    static int n;

    static int binarySearch(int target) {
        int st = 0;
        int en = n - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (a[mid] < target)
                st = mid + 1;
            else if (a[mid] > target)
                en = mid - 1;
            else
                return 1;
        }
        return 0; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        int m = sc.nextInt();
        while (m-- > 0) {
            int t = sc.nextInt();
            System.out.println(binarySearch(t));
        }
    }
}
