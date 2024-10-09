import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    /*
     * 부녀 회장이 될꺼야
     * 해결 방안: 입력 값이 크지 않는 이상 모든 배열의 값을 구해서 하는게 더 편하다.
     * 점화식을 만드려고 하다가 시간만 보냈다.
     * */

    public static int[][] APT = new int[15][15];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        make_APT();    // 아파트 만들기

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(APT[k][n]).append('\n');
        }
        System.out.println(sb);
    }


    public static void make_APT() {
        // 아파트 생성

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1; // i층 1호, 나머지 호수는 먼저 이렇게 초기화를 해준다.
            APT[0][i] = i; // 0층 i호, 이렇게 하는 이유는 0층은 항상 값이 고정되어 있기 때문이다.
        }

        for (int i = 1; i < 15; i++) { // 1층부터 14층까지

            for (int j = 2; j < 15; j++) { // 2호부터 14호까
                // 1호는 항상 1로 고정이기 때문에 2부터 시작한다.
                // APT[i][j-1]: 구하는 층의 전 호수 갯수
                // APT[i-1][j]: 구하는 전 층의 지금 호수 갯수
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];
            }
        }
    }

}