import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(t)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
