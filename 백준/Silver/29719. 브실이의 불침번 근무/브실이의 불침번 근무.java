import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      long all = pow(m, n);
      long except = pow(m-1, n);

      // 음수인 경우 때문에 MOD를 더해준다.
      long answer = (all - except + MOD) % MOD;

      System.out.println(answer);
    }

    // 거듭제곱 시, 더 큰수가 나올 수 있어서 모듈러 연산을 통해서 수를 줄여준다.
    // 스택 오버 플로우를 방지하기 위해서
    static long pow(int base, int exponent){
      long result = 1;
      for(int i = 0; i<exponent; i++){
        result = (result * base) % MOD;
      }
      return result;
    }

}