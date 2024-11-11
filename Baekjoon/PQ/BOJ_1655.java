import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 * : 로직을 한번 더 생각해보면 좋을 것 같다.
 * */
public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if (maxPQ.size() == minPQ.size()) {
                maxPQ.add(a);

                if (!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            } else {
                minPQ.add(a);

                if (maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }

            System.out.println(maxPQ.peek());
        }
    }
}