import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				st.pop();
			} else {
				st.push(input);
			}
		}
		while (!st.isEmpty()) {
			sum += st.pop();
		}
		System.out.println(sum);
	}
}