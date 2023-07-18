import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] time = new int[n][2];

        for(int x =0; x<n; x++){
            time[x][0] = sc.nextInt();
            time[x][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1 == o2) {
                    return o1[0] - o2[1];
                }
                return o1[1] - o2[1];
            }
        });

        int prevTime = 0;
        int count = 0;
        for(int x = 0; x<n; x++){
            if(prevTime <= time[x][0]){
                count++;
                prevTime = time[x][1];
            }
        }
        System.out.println(count);

    }
}