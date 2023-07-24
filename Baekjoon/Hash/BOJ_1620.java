import java.util.HashMap;
import java.util.Scanner;
/*
* 나는야 포켓몬 마스터 이다솜
* */
public class BOJ_1620 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[100005];

        HashMap<String, Integer> map = new HashMap<>();
        for (int x = 1; x <= n; x++) {
            arr[x] = sc.nextLine();
            map.put(arr[x], x);
        }

        while (m-- > 0) {
            String input = sc.nextLine();
            if (Character.isDigit(input.charAt(0))) {
                System.out.println(arr[Integer.parseInt(input)]);
            } else System.out.println(map.get(input));
        }
        sc.close();
    }
}