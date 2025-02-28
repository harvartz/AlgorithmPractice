import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 브실이를 포함한 경우의 수
        long in = pow(m, n);
        // 브실이를 제외한 경우의 수
        long out = pow(m - 1, n);

        // 브실이가 들어가 있는 경우의 수
        long result = (in - out + MOD) % MOD;
        System.out.println(result);
    }

    // 거듭제곱 계산 (모듈로 연산 적용)
    static long pow(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result = (result * base) % MOD;
        }
        return result;
    }
}