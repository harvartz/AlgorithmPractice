import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int dx[] = { -1, 0, 1, 0, 1, -1, -1, 1 };
	static int dy[] = { 0, -1, 0, 1, 1, -1, 1, -1 };
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		ArrayList<Integer> answer = new ArrayList<>();
		boolean check = false;

		while (!check) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			count = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(new Point(i, j));
						count++;
					}
				}
			}
			answer.add(count);
		}

		for (int a : answer) {
			System.out.println(a);
		}
	}

	static void dfs(Point p) {
		visited[p.x][p.y] = true;
		for (int i = 0; i < 8; i++) {
			int d_x = p.x + dx[i];
			int d_y = p.y + dy[i];

			if (0 <= d_x && d_x < h && 0 <= d_y && d_y < w) {
				if (!visited[d_x][d_y] && map[d_x][d_y] == 1) {
					dfs(new Point(d_x, d_y));
				}
			}
		}
	}
}