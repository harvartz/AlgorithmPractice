import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 결혼식
* https://www.acmicpc.net/problem/5567
*
* */
public class BOJ_5567 {

    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> friends;
    static int[] isFriend;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 1. 초기화 과정
        friends = new ArrayList<>();
        for (int x = 0; x <= n; x++) {
            friends.add(new ArrayList<>());
        }

        // 2. 데이터 입력 과정
        for (int x = 0; x < m; x++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        // 각 노드마다 주인공과의 관계 표시
        // cnt = 1이면 동기, 2이면 친구의 친구
        isFriend = new int[n + 1];
        visited = new int[n + 1];

        bfs(1);

        int resultCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isFriend[i] <= 3 && isFriend[i] > 0) {
                resultCount++;
            }
        }

        System.out.print(resultCount);
    }

    static void bfs(int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        isFriend[start] = 1;

        while(!qu.isEmpty()) {
            int num = qu.poll();

            for(int x : friends.get(num)){
                if(isFriend[x] == 0){
                    isFriend[x] = isFriend[num] + 1;
                    qu.offer(x);
                }
            }
        }
    }
}