import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[][] map;
    static int count = 0;
    // 정점 N개, 간선 M개
    // 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
    // 간선은 한 번만 주어진다.

    public static void dfs(int start){
        
        for(int i = 0; i<N; i++){
            if(map[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            map[start][end] = 1;
            map[end][start] = 1;
        }

        for(int i = 0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
