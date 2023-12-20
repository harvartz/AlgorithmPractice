import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] brr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            brr[x] = Integer.parseInt(st.nextToken());
        }

        for (int x : T.solution(n, arr, brr)) {
            System.out.println((char) x);
        }
    }

    public ArrayList<Character> solution(int n, int[] arr, int[] brr) {
        ArrayList<Character> answer = new ArrayList<>();
        /*
         나는 7가지의 경우의 수(a가 이긴 경우, b가 이긴경우)이렇게 생각했는데
         알고보니 하나만 생각하면 나머지는 자연스럽게 처리할 수 있다
         else if의 특성을 제대로 활용한 것
        */
        for (int x = 0; x < n; x++) {
            if (arr[x] == brr[x]) answer.add('D');
            else if (arr[x] == 1 && brr[x] == 3) answer.add('A');
            else if (arr[x] == 2 && brr[x] == 1) answer.add('A');
            else if (arr[x] == 3 && brr[x] == 2) answer.add('A');
            else answer.add('B');
        }
        return answer;
    }
}