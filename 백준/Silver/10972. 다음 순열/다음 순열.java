import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation(arr)){
            for(int num : arr){
                System.out.print(num + " ");
            }
        }else{
            System.out.println(-1);
        }
    }

    public static boolean nextPermutation(int[] arr){
        int n = arr.length;
        int i = n - 2;

        // 내림차순이 깨지는 시점 찾기 
        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }

        if(i < 0){
            return false;
        }

        // i보다 큰 값 중 가장 작은 값과 swap
        int j = n - 1;
        while(arr[i] >= arr[j]){
            j--;
        }
        swap(arr, i, j);

        reverse(arr, i + 1, n - 1);

        return true;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start++, end--);
        }
    }
}