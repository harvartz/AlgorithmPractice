import java.util.HashMap;
import java.util.Scanner;
/*
* 패션완 신해빈
* */
public class BOJ_9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();

            for (int x = 0; x < n; x++) {
                String name = sc.next();
                String clothes = sc.next();

                if (map.containsKey(clothes)) {
                    map.put(clothes, map.get(clothes) + 1);
                } else {
                    map.put(clothes, 1);
                }
            }

            int result = 1;
            for (int val : map.values()) {
                result *= (val + 1);
            }
            System.out.println(result - 1);
        }
    }
}