import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(n, m));
    }

    public int solution(int n, int m) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int x = 1; x <= n; x++) {
            queue.add(x);
        }
        /* count = 0으로 했었는데, 0으로 한 경우 m을 count할 때 +1번 더하게 된다.
         *  그러기 때문에 1로 해줘야 제대로 count가 된다 */

        /* 답에서는 while문보다는 for문을 사용했는데 for문을 왜 활용할 생각을 하지 못하지
         *  for문의 조건식을 count 하는 것과 동일하다고 생각하자
         *  while 문은 내가 구하고자 하는 값의 조건이 무엇인지 정확히 모르거나 유동적일 때 사용*/
        int count = 1;
        while (queue.size() != 1) {
            if (count == m) {
                count = 1;
                queue.poll();
            } else {
                count++;
                queue.add(queue.poll());
            }
        }

        /*
        while (!queue.isEmpty()) {
            for (int i = 1; i < m; i++) {
                queue.poll();
                if (queue.size() == 1) answer = queue.poll();
            }
        }*/

        answer = queue.poll();
        return answer;
    }
}