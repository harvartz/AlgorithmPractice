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
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            arr[x] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n, k, arr));
    }

    public int solution(int n, int k, int[] arr) {

        /*
         * 중복 제거 => Set 사용
         * 정렬 사용 => TreeSet 사용
         * TreeSet 순서는 유지하지 않는다
         * */
        int count = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                for (int z = y + 1; z < n; z++) {
                    treeSet.add(arr[x] + arr[y] + arr[z]);
                }
            }
        }

        int cnt = 0;
        for (int x : treeSet) {
            cnt++;
            if (cnt == k) return x;
        }
        return -1;
    }

    /*
     * 1. n의 크기가 작기 때문에 3중 for문으로 해결
     * 2. 중뵥과 정렬을 처리해야 하기 때문에 TreeSet 자료구조 사용
     * 3. TreeSet 자료구조의 메소드
     * - add, remove
     * - size : 원소의 개수 */

    /* set 자료구조는 중복제거를 위해 사용
     * 정렬이 필요한 map을 만드려면 treeMap을 사용
     * -> 이진트리 레드블랙 트리*/
}