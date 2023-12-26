import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // 인덱스를 처음부터 처리해서 진행하는게 직관적이긴 할 것 같다.
        int[][] arr = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 6; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(arr, n));
    }


    public int solution(int[][] arr, int n) {

        int max = Integer.MIN_VALUE;
        int answer = 0;
        /*
         * 각 인덱스가 어떤 의미를 하고 있는지 확인하고 사용하자
         * x : 비교대상, y: 나머지 비교 대상, z: 학년
         * */
        for (int x = 1; x <= n; x++) {
            int cnt = 0;
            for (int y = 1; y <= n; y++) {
                // if( x != y) for ....
                // 같은 경우는 위와같이 처리하면 편하다.
                for (int z = 1; z <= 5; z++) {
                    // 학년이 중복되서 같은 경우는 필요 없기 때문에 break를 해준 것이다.
                    if (arr[x][z] == arr[y][z]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = x;
            }
        }
        return answer;
    }
}