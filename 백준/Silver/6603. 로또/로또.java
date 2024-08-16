import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int count = 0;
	static int[] arr;
	static boolean[] visited;
	static int[] brr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			arr = new int[N];
			brr = new int[6];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			permutation(0, 0);
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	static void permutation(int level, int start) {
		if (level == 6) {
			for (int i : brr) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < N; i++) {
			brr[level] = arr[i];
			permutation(level + 1, i + 1);
		}
	}
}
