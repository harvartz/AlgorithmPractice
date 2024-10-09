import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		for (int x = 0; x < input.length(); x++) {
			list.add(input.charAt(x));
		}

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();

		// iterator 메소드 호출
		ListIterator<Character> iter = list.listIterator();

		// 처음 커서는 문장의 맨 뒤에 있기 때문에 커서를 맨 뒤로 이동시켜준다.
		while (iter.hasNext()) {
			iter.next();
		}

		while (N-- > 0) {
			String command = br.readLine();
			char c = command.charAt(0);

			switch (c) {
			case 'L':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D':
				if (iter.hasNext())
					iter.next();
				break;
			case ('B'):
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case ('P'):
				char t = command.charAt(2);
				iter.add(t);
				break;
			}
		}

		for (Character i : list) {
			sb.append(i);
		}
        System.out.println(sb);
		br.close();
	}
}
