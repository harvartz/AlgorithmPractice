import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    // 사용할 치킨집 좌표
    static int[][] answer;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/main/resources/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        answer = new int[M][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {     // 치킨 집 좌표를 담는다.
                    chickens.add(new int[]{i, j});
                }
                if (map[i][j] == 1) {     // 가정집 좌표를 담는다.
                    houses.add(new int[]{i, j});
                }
            }
        }
        recur(0, 0);
        System.out.println(result);
    }

    static void recur(int level, int choose) {
        if (level == M) {
            int sum = 0;


            for (int[] chooseHouse : houses) {
                // 하나의 가정집에서 각 치킨 집의 거리를 구해서 최솟값을 구한다.
                int min = Integer.MAX_VALUE; // 각 가정집마다 min을 초기화
                for (int[] chooseChicken : answer) {
                    // System.out.println("고른 치킨집 좌표" + Arrays.toString(chooseChicken));
                    int dist = Math.abs(chooseChicken[0] - chooseHouse[0]) + Math.abs(chooseChicken[1] - chooseHouse[1]);
                    //System.out.println(dist);
                    min = Math.min(min, dist);
                }
               // System.out.println("min: " + min);
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }
        for (int i = choose; i < chickens.size(); i++) {
            answer[level] = chickens.get(i);
            recur(level + 1, i + 1);
        }
    }
}
