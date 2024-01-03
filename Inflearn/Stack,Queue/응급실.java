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

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, m, arr));
    }

    public int solution(int n, int m, Integer[] arr) {
        int answer = 0;
        /*위험도가 높은 순으로 큐에 넣은 다음에 하나씩 뺴면서 목표*/
        Queue<Person> Queue = new LinkedList<>();
        for (int x = 0; x < n; x++) {
            Queue.offer(new Person(x, arr[x]));
        }
        while (!Queue.isEmpty()) {
            Person tmp = Queue.poll();
            for (Person x : Queue) {
                if (x.priority > tmp.priority) {
                    Queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) return answer;
            }
        }
        return answer;
    }

    class Person {
        // id는 처음 들어왔을 때의 순서
        int id;
        // priority 는 응급 순서
        int priority;

        Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
    /* Person이라는 클래스를 생각하긴 했다.
     * 나머지는 그냥 MAX값을 구하는 과정과 비슷하다.
     * tmp에 값을 넣고 우선순위를 비교하여 하나씩 지우면서 순서를 세우는 과정이다*/
}