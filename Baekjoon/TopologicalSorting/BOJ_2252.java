import java.io.IOException;
import java.util.*;

/*
* 줄세우기
* https://www.acmicpc.net/problem/2252
* */
public class BOJ_2252 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<ArrayList<Integer>> arr = new ArrayList<>();
        int[] indegree = new int[n + 1];
        for(int x = 0; x<=n; x++){
            arr.add(new ArrayList<>());
        }

        for (int x = 0; x < m; x++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.get(s).add(e);
            indegree[e] += 1;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int x = 1; x <= n; x++) {
            if(indegree[x] == 0){
                qu.offer(x);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!qu.isEmpty()){
            int out = qu.poll();
            result.add(out);

            for(int x : arr.get(out)){
                indegree[x] -= 1;
                if(indegree[x] == 0){
                    qu.offer(x);
                }
            }
        }

        for(int x : result){
            System.out.print(x + " ");
        }
    }
}