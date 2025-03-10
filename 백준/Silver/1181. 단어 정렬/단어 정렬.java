import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, (e1, e2) -> {
			if (e1.length() == e2.length()) {
				return e1.compareTo(e2);
			} else {
				return e1.length() - e2.length();
			}
		});

		System.out.println(arr[0]);

		for (int i = 1; i < N; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}
	}
}
