import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] numbers;
	static int[] operators = new int[4]; // +, -, *, /
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		recur(1, numbers[0]);

		System.out.println(max);
		System.out.println(min);
		br.close();
	}

	static void recur(int index, int current) {
		if (index == N) {
			// 모든 숫자를 다 사용한 경우, 최댓값과 최솟값 갱신
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				// 연산자를 사용
				operators[i]--;

				switch (i) {
					case 0:
						recur(index + 1, current + numbers[index]);
						break;
					case 1:
						recur(index + 1, current - numbers[index]);
						break;
					case 2:
						recur(index + 1, current * numbers[index]);
						break;
					case 3:
						recur(index + 1, current / numbers[index]);
						break;
				}

				// 연산자 사용을 취소 (백트래킹)
				operators[i]++;
			}
		}
	}
}
