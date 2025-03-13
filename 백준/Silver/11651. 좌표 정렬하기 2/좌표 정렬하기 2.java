import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 맨날 까먹는 이 부분 기억좀 하자
        // Arrays.sort(정렬하고자 하는 배열, (배열안에서 비교 대상1, 배열 안에서 비교 대상 2) -> {})
        // 대괄호 안에는 어떤 기준으로 배열을 다시 정렬할지 정하는 것

        Arrays.sort(arr, (o1, o2)-> {
            // 두번쨰열이 같다면?
            if(o1[1] == o2[1]){
                return o1[0] - o2[0]; // 첫번째 열을 기준으로 오름차순
            }
            // 두번째 열을 기준으로 오름차순 정렬
            return o1[1] - o2[1];
        });

        StringBuilder sb = new StringBuilder();
        // 참고로 Arrays.toString(출력하고자 하는 배열)을 하면 반복문 하나로 2차원 배열을 출력할 수 있습니답
        for(int i = 0; i<N; i++){
            for(int j = 0; j<2; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}