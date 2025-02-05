import java.io.*;

public class Main {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);

        prime = new boolean[N + 1];
        get_prime();

        for (int x = M; x <= N; x++) {
            if (!prime[x]) {
                System.out.println(x);
            }
        }

    }

    public static void get_prime() {
        prime[0] = prime[1] = true; // 0과 1은 소수가 아님

        for (int x = 2; x <= Math.sqrt(prime.length); x++) {
            if (prime[x]) continue;
            for (int y = x * x; y < prime.length; y += x) {
                prime[y] = true;
            }
        }
    }
}