import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        // 15개의 문자를 붙여서 문자열로 해야 하는데 어떻게 해야 하는가?
        // 답에서는 그냥 String으로 받네?
        // => toCharArray()를 사용하면 문자열을 그냥 문자 배열로 바꿔ㅓ준다.
        System.out.println(T.solution(n, str));
    }

    public static char solution(int n, String str) {
        // HashMap은 언제 사용하는가?

        HashMap<Character, Integer> map = new HashMap<>();

        // 해당 Key가 없으면 default값으로 초기화하기
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        char answer = ' ';
        // keySet : key를 모두 조회하는 메소드
        // get : 해당 Key의 Value를 가져오는 메소드
        // containesKey() : Key가 있는지 true, false 반환
        // size() : Map의 크기를 나타내는 것
        int max = Integer.MIN_VALUE;
        for (char x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                answer = x;
            }
        }
        return answer;
    }
}