import java.util.Scanner;

/*
* 나무 자르기
* Upper Bound, Lower Bound 개념 확인
* */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] trees = new int[N];

        int min = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {
            trees[i] = in.nextInt();

            if(max < trees[i]) {
                max = trees[i];
            }
        }

        while(min < max) {

            int mid = (min + max) / 2;
            long sum = 0;
            for(int treesHeight : trees) {

                if(treesHeight - mid > 0) {
                    sum += (treesHeight - mid);
                }
            }

            if(sum < M) {
                max = mid;
            }

            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}