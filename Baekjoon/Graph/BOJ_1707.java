import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 이분 그래프
* https://www.acmicpc.net/problem/1707
* */
public class BOJ_1707 {
    static int[][] adj;
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] color;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();


        while (k-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            color = new int[v + 1];
            arr = new ArrayList<>();
            // 1. 그래프 초기화
            for (int x = 0; x <= v; x++) {
                arr.add(new ArrayList<>());
            }

            // 2. 그래프 연결
            for (int x = 0; x < e; x++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr.get(a).add(b);
                arr.get(b).add(a);
            }


            boolean colored = false;
            // 3. 색칠되지 않은 모든 정점 탐색
            for (int y = 1; y <= v; y++) {
                // 3-1. 색칠되지 않았다면 색칠하기
                if(color[y] == 0){
                    colored = bfs(y, 1);
                }
                if(!colored) break;
            }
            if(colored) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean bfs(int start, int colored){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);

        // 4-1. 시작 정점 임의의 색상으로 색칠
        color[start] = colored;
        while (!qu.isEmpty()) {
            int poll = qu.poll();
            for (int i : arr.get(poll)) {
                // 4-2. 인접 정점 색이 동일하면 이분 그래프가 아님
                if (color[i] == color[poll]) {
                    return false;
                }
                // 4-3. 인접 정점 색칠 안된 경우, 현재 정점 반대 색깔로 색칠
                if(color[i] == 0){
                    color[i] = color[poll] * -1;
                    qu.add(i);
                }
            }
        }
        return true;
    }
}