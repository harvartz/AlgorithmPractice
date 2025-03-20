import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int x = 0; x < n; x++) {
            int now = x; // 지금 생성자를 찾아보려고 하는 분해합 숫자
            int answer = 0; //

            while (now != 0) { // 0이 될 때까지 계속 나누기, 자릿수를 찾기 위해서
                answer += now % 10; // 자릿수 찾아서 계속 더해주기
                now /= 10; // 자릿수를 찾았으니 다음 자릿수를 찾기 위해 10을 나눠주기
            }

            if (x + answer == n) {
                result = x;
                break;
            }
        }
        System.out.println(result);

    }
}
