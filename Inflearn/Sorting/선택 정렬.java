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

        for (int x = 0; x < n - 1; x++) {
            int min_index = x;
            for (int y = x + 1; y < n; y++) {
                if (arr[min_index] > arr[y]) {
                    min_index = y;
                }
            }
            swap(arr, min_index, x);
        }
        return arr;
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}