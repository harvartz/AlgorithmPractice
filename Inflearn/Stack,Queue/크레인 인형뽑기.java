import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < n; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < m; x++) {
            moves[x] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(board, n, m, moves));
    }

    public int solution(int[][] board, int n, int m, int[] moves) {

        int count = 0;
        Stack<Integer> st = new Stack<>();

        /* 1. 스택에 하나씩 넣기
         *  2. moves[x]+1 -> 행 선택
         *  3. */
        for (int x = 0; x < m; x++) {

             int y = 0;
            /* 이렇게 코드를 작성한 이유는 0을 만날때까지 반복하기 위해서 while문을 사용한 것
             *  하지만 for문을 사용하고 break를 사용하는 것이 조금 더 직관적인 것 같다
             *  아래의 코드가 읽기가 훨씬 직관적이다*/

            /*for (int y = 0; y < n; y++) {
                if (board[y][moves[x] - 1] != 0) {
                    int tmp = board[y][moves[x] - 1];
                    board[y][moves[x] - 1] = 0;
                    if (!st.isEmpty() && tmp == st.peek()) {
                        count += 2;
                        st.pop();
                    }else st.push(tmp);
                    break;
                }
            }*/

            while (y < n && board[y][moves[x] - 1] == 0) {
                y++;
            }
            if (y == n) continue;

            if (!st.isEmpty() && st.peek() == board[y][moves[x] - 1]) {
                board[y][moves[x] - 1] = 0;
                st.pop();
                count += 2;
            } else {
                st.push(board[y][moves[x] - 1]);
                board[y][moves[x] - 1] = 0;
            }
        }
        return count;
    }

    /*
     * 범위에서 벗어나는 경우를 생각하지 못했다.
     * 그리고 터지는 경우, 결국 2개의 인형을 터트리는 것이기 때문에 answer += 2를 해줘야한다*/
}