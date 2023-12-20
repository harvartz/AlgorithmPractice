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
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, arr));
    }

    public int solution(int n, int[] arr) {
        /*
         학생이 제일 큰 사람이 맨 앞에 있으면 한사람 밖에 보이지 않기 때문에
         초기 값을 1로 해줘야 한다.
        */
        int count = 1;
        // 맨 앞에 학생은 이미 넣었기 때문에 다음과 같이 초기화를 해줬다.
        int max = arr[0];
        // 맨 앞에 학생은 이미 체크했기 때문에 1부터 한 것이다.
        for (int x = 1; x < n; x++) {
            if (arr[x] > max) {
                max = arr[x];
                count++;
            }
        }
        return count;
    }
}