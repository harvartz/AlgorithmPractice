import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.offer(input);
            if (input == 0) {
                sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}