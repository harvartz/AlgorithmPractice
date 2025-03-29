import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int x = 0; x < arr.length; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[x][0] = Integer.parseInt(st.nextToken());
            arr[x][1] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < N; x++) {
            int rank = 1;
            for (int y = 0; y < N; y++) {
                // 같으면 넘기기
                if (x == y) continue;
                // 범위안에 들면 rank를 늘림
                if (arr[x][0] < arr[y][0] && arr[x][1] < arr[y][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}