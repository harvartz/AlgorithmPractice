import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        dfs(0, new int[M]);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[] answers) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            answers[depth] = nums[i];
            dfs(depth + 1, answers);
        }
    }
}