import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static boolean[] v;
	static int N, M;

	static int count = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		for (int x = 0; x < M; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			int go = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			map[go][from] = 1;
			map[from][go] = 1;
		}

		// dfs(1);
		bfs(1);
		System.out.println(count);
	}

	static void dfs(int i) {
		v[i] = true;

		for (int j = 1; j <= N; j++) {
			if (!v[j] && map[i][j] == 1) {
				v[j] = true;
				count++;
				dfs(j);
			}
		}
	}

	static void bfs(int i) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		v[i] = true;

		while (!q.isEmpty()) {
			i = q.poll();
			for (int j = 1; j <= N; j++) {
				if (!v[j] && map[i][j] == 1) {
					v[j] = true;
					count++;
					q.offer(j);
				}
			}
		}
	}
}
