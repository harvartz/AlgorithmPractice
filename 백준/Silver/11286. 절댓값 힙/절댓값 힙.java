import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> qu = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });
        while (size-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                int out = qu.isEmpty() ? 0 : qu.poll();
                sb.append(out).append("\n");
            } else {
                qu.offer(input);
            }
        }
        System.out.println(sb);
    }
}
