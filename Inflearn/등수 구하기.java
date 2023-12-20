import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
        for (int a : T.solution(n, answer)) {
            System.out.print(a + " ");
        }

    }

    public ArrayList<Integer> solution(int n, int[] answer) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            // 등수는 본인의 등수는 포함하고 시작하기 때문에 1부터 시작한다.
            int count = 1;
            // 점수가 같은 경우, 음.. 같은 경우 또한 결국은 크지않기 때문에 count가 되지 않아
            // 동일한 등수로 확인할 수 있다.
            for (int y = 0; y < n; y++) {
                if (answer[x] < answer[y]) {
                    count++;
                }
            }
            arr.add(count);
        }

        return arr;
    }
}