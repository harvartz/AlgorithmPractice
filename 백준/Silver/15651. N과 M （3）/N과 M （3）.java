import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean visited[];
	static int[] answer;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N+1];
		answer = new int[M];

		recur(0);
		System.out.println(sb);
	}

	static void recur(int n) {
		if (n == M) {
			for (int b : answer) {
				sb.append(b).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int a = 1; a <= N; a++) {

			answer[n] = a;
			recur(n + 1);
		}
	}
}
