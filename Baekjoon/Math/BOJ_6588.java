import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {

    /*
     * 골드 바흐의 추측 : https://www.acmicpc.net/problem/6588
     * */
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;


        for (int x = 2; x <= Math.sqrt(1000000); x++) {
            if (isPrime[x]) {
                continue;
            }
            for (int y = x * x; y < 1000000; y = y + x) {
                isPrime[y] = true;
            }
        }

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) return;
            int first = 0;
            int second = 0;

            for (int x = 2; x <= input; x++) {
                if (!isPrime[x] && x % 2 == 1) {
                    first = x;
                    second = input - x;
                    System.out.println(input + " = " + first + " + " + second);
                    break;
                }
            }

            if (first == 0) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }


}