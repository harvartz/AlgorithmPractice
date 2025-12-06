import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] pattern = br.readLine().toCharArray(); // 기준 문자열
        for (int i = 1; i < n; i++) {
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != cur[j]) {
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(new String(pattern));
    }
}
