import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 최소힙
* https://www.acmicpc.net/problem/1927
* : 직접 구현하는 것도 추천한다.
* */
public class BOJ_1927 {


    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = sc.nextInt();
        for (int x = 0; x < n; x++) {
            int input = sc.nextInt();

            if (input == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.add(input);
            }

        }

    }
}