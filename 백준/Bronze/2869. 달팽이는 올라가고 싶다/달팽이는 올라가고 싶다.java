import java.io.*;
import java.util.*;

class Main {
    /*
     * 해결방법: 반복문을 돌려서 조건에 만족할때까지 더하고 빼주면 될 줄 알았지만, 시간초과가 떴다.
     * 반복문을 돌리는 것보다 아래처럼 몫을 나누는게 훨씬 빠르다.
     * 다만, 거리에 도달하면 미끄러지지 않은 조건이 있기 떄문에 다음과 같은 조건을 하나 더 추가해줬다.
     * 1. 정확하게 0으로 떨어지면 나눈 값을 days에 대입하면 된다.
     * 2. 하지만 잔여거리가 남아있다면 한번 더 움직여야 하기 때문에 하루를 더 해준 것이다.
     * 여기에서 length - down을 한 이유는 바로 최소한의 일수를 구하기 위해서이다.
     * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int day = (length - down) / (up - down); // 정확하게 0으로 떨어지면
        if ((length - down) % (up - down) != 0) // 잔여 거리가 남는다면 내려간다음에 한번 더 올라와야 하기 때문에 하루를 더 추가해준다.
            day++;

        System.out.println(day);
    }
}