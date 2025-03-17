import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 참가자 수 입력
        int N = Integer.parseInt(br.readLine());

        // 티셔츠 사이즈별 신청자 수 입력
        st = new StringTokenizer(br.readLine(), " ");
        int[] sizes = new int[6]; // S, M, L, XL, XXL, XXXL
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        // 묶음 단위 입력
        st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()); // 티셔츠 묶음 크기
        int B = Integer.parseInt(st.nextToken()); // 펜 묶음 크기

        // (1) 티셔츠 묶음 개수 계산 (올림)
        int tshirtBundles = 0;
        for (int i = 0; i < 6; i++) {
            tshirtBundles += (sizes[i] + A - 1) / A; // 올림 계산
        }
        System.out.println(tshirtBundles);

        // (2) 펜 묶음 개수 계산
        int penBundles = N / B;  // 최대 묶음 개수
        int remainingPens = N % B; // 나머지 개별 주문할 펜 수
        System.out.println(penBundles + " " + remainingPens);
    }
}
