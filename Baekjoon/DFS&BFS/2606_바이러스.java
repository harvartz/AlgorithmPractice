import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static ArrayList<ArrayList<Integer>> computer = new ArrayList<>(); // 인접리스트로 만든 네트워크
    static int[] virus; // 컴퓨터에 바이러스가 걸리면 체크하는 배열
    static int count = 0; // 바이러스가 걸린 컴퓨터의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int command = Integer.parseInt(br.readLine());

        for (int x = 0; x <= n; x++) {  // n을 포함하는 이유는 0번 컴퓨터는 없음으로 1번부터 n번까지 범위 지정
            computer.add(new ArrayList<>()); // 입력받은 n의 개수만큼 인접리스트 안에 배열 리스트 객체 생성
        }

        for (int x = 0; x < command; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer.get(a).add(b);
            computer.get(b).add(a); // 연결되어 있다는 거은 그래프가 양방향이라는 뜻이니 한 쪽을 더해주면 반대쪽도 더해줘야 한다.
        }

        virus = new int[n + 1]; // virus 배열

        dfs(1); // dfs 시작

        System.out.println(count); // 정답 출력
    }

    static void dfs(int start) {
        virus[start] = 1; // dfs에 들어오면 해당 컴퓨터에 방문했다는 뜻, 해당하는 인덱스에 체크! 1 대입

        for (int a : computer.get(start)) { // 이제 방문한 컴퓨터를 기준으로 연결되어 있는 컴퓨터를 하나씩 순회함
            if (virus[a] == 1) continue; // 1은 방문했다는 뜻이니 다음 반복문으로 넘기기
            count++; // 그게 아니면 count하기
            dfs(a);
        }
    }
}
