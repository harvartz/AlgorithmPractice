import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int count = 0;

		// 입력받은 수에서 5의 거듭제곱으로 나누며 0의 개수 세기
		while (num >= 5) {
			// num을 5로 나눈 몫을 count에 더함 (5의 배수마다 0이 하나씩 추가됨)
			count += num / 5;

			// num을 5로 나눔 (다음 반복에서는 25, 125, ... 배수를 처리하기 위함)
			num /= 5;
		}

		System.out.println(count);
	}
}