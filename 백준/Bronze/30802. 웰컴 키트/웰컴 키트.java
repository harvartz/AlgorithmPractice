import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[] sizes = new int[6]; 
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); // 티셔츠 묶음 크기
        int B = Integer.parseInt(st.nextToken()); // 펜 묶음 크기

        // (1) 티셔츠 묶음 개수 계산 (올림)
        int tshirtBundles = 0;
        for (int i = 0; i < 6; i++) {
            // A-1을 해야지 A의 배수를 넘어가는 경우, 다음 몫으로 자동으로 넘어간다고 함
            // A로 딱 나눠떨어지는 경우에도 한 묶음을 더 주문하는 오류가 발생함!
            // -> 이런 생각은 도데체 어떻게 해야하는거야
            // EX) 10 /5 = 2인데, 10 + 5 / 5 =3으로 하나를 더 주문하는 오류가 생겨버림
            tshirtBundles += (sizes[i] + A - 1) / A;
        }
        System.out.println(tshirtBundles);

        // (2) 펜 묶음 개수 계산
        int penBundles = N / B;  // 최대 묶음 개수
        int remainingPens = N % B; // 나머지 개별 주문할 펜 수
        System.out.println(penBundles + " " + remainingPens);
    }
}
