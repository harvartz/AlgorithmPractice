import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            answer[x] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        for (int x : T.solution(n, answer)) {
            System.out.print(x + " ");
        }
    }

    public ArrayList<Integer> solution(int n, int[] answer) {
        /* 일단 수를 모두 뒤집어 놓는게 좋겠지?
        일단 생각나는 것은 10의 자리의 수를 나누어서 나머지를 다른 변수에 보관했다가
        앞뒤를 바꿔주면 된다.
        그런데 세 자리 수면 어떻게 자릿수를 바꿔주는가? 네자리면? 다섯자리면?
        => 해결 방법
        */
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = answer[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) arr.add(res);
        }

        /* 1. 에라토스테네스의 체
         * 다음으로 숫자를 바꿨으면 해당 숫자가 소수인지 판별해야 한다.
         * 먼저 가지고 있는 수 중에서 가장 큰 수를 선택해서 에라토스테네스의 체를 돌린다.
         * 그리고 해당 인덱스의 값이 0인지 1인지 판단하면 된다.
         * */
       /* int max = 0;
        for (int x = 0; x < n; x++) {
            if (answer[x] > max) max = answer[x];
        }

        int[] check = new int[max + 1];
        int count = 0;
        for (int x = 2; x <= max; x++) {
            if (check[x] == 0) {
                count++;
                for (int j = x; j <= max; j = x + j) {
                    check[j] = 1;
                }
                System.out.print(check[x] + " ");
            }
        }*/
        return arr;
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        // 해당 수 미만의 범위 내에서 배수가 하나라도 있으면 그 수는 소수가 아니다.
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}