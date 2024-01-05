import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    public int[] solution(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            int target = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (target < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            /* 위의 반복문에서 탈출했다는 뜻은 target보다 앞의 값이 작다는 뜻이기 때문에
            *  target을 j+1값에 넣어준다 */
            arr[j + 1] = target;
        }
        return arr;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}