import java.util.*;

/*
* 음악 프로그램
* https://www.acmicpc.net/problem/2623
*
* */
public class BOJ_2623 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<ArrayList<Integer>> sort = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            sort.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        for (int x = 0; x < m; x++) {
            int singer = sc.nextInt();
            int prev = sc.nextInt();
            for (int y = 1; y < singer; y++) {
                int cur = sc.nextInt();
                sort.get(prev).add(cur);
                indegree[cur]++;
                prev = cur;
            }
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int x = 1; x <= n; x++) {
            if (indegree[x] == 0) {
                qu.offer(x);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!qu.isEmpty()) {
            int out = qu.poll();
            result.add(out);
            for (int x : sort.get(out)) {
                indegree[x] -= 1;
                if (indegree[x] == 0) {
                    qu.offer(x);
                }
            }
        }

        if(result.size() != n){
            System.out.println("0");
        }else{
            for (int x : result) {
                System.out.println(x);
            }
        }
    }
}