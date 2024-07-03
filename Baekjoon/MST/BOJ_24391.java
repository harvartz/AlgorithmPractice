import java.io.*;
import java.util.*;

class Main {

    static int[] p;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        make(); // 부모 배열 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1; // 0-based 인덱스 변환
            int to = Integer.parseInt(st.nextToken()) - 1;   // 0-based 인덱스 변환
            union(from, to); // 간선 처리
        }

        int cnt = 0; // 결과 카운트 변수
        int[] answer = new int[N]; // 정점 이동 순서 배열
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken()) - 1; // 0-based 인덱스 변환
        }

        // 디버깅 출력을 추가하여 부모 배열 상태 확인

        for (int i = 1; i < N; i++) {
            if (find(answer[i - 1]) != find(answer[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    // 부모 배열 초기화 함수
    static void make() {
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i; // 자신을 부모로 초기화
        }
    }

    // 경로 압축을 적용한 find 함수
    static int find(int i) {
        if (p[i] == i) // 자신이 루트인 경우
            return i;
        return p[i] = find(p[i]); // 경로 압축
    }

    // union 함수, 두 집합을 합치는 함수
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false; // 이미 같은 집합인 경우
        if (aRoot < bRoot) p[bRoot] = aRoot; // 작은 쪽을 부모로 설정
        else p[aRoot] = bRoot;
        return true;
    }
}
