import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 크기
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 절사 평균: 가장 큰 값들과 가장 작은 값들을 제외
        // 상위 15%, 하위 15% 자르고 평균 내기잖아 결국

        // 1. 일단 정렬하기
        Arrays.sort(arr);

        // 2. 상위 15%, 하위 15% 사람 고르기
        // 반올림 -> Math.round(), 올림 -> ceil, 내림 -> floor();
        int percent =  (int) Math.round(N * 0.15);

        // 왜 double이어야 할까
        double sum = 0;
        for(int i = percent; i < N - percent; i++){
            sum += arr[i];
        }

        // sum이 double이 아니면 나눗셈하는 과정에서 반올림할 소수점이 날라가 버린다.
        int answer = (int)Math.round(sum / (N - (2 * percent)));
        System.out.println(answer);
    }
}