import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String subStr = br.readLine();

        System.out.println(T.solution(str, subStr));
    }

    public int solution(String str, String subStr) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> subMap = new HashMap<>();
        char[] sub = subStr.toCharArray();
        char[] ana = str.toCharArray();

        for (int x = 0; x < subStr.length(); x++) {
            subMap.put(sub[x], subMap.getOrDefault(sub[x], 0) + 1);
        }

        for (int x = 0; x < subStr.length() - 1; x++) {
            map.put(ana[x], map.getOrDefault(ana[x], 0) + 1);
        }

        int count = 0;
        int lt = 0;
        for (int x = subStr.length() - 1; x < ana.length; x++) {
            map.put(ana[x], map.getOrDefault(ana[x], 0) + 1);
            if (map.equals(subMap)) count++;
            map.put(ana[lt], map.get(ana[lt]) - 1);
            if (map.get(ana[lt]) == 0) map.remove(ana[lt]);
            lt++;
        }

        return count;
    }

    /*
     * 내가 왜 이 문제를 고민하고 못 풀었을까?
     * 1. 객체 비교에 있어서 equals를 사용할 생각을 못하고 2중 for문을 사용하여 O(n^2)이 된 것 같다.
     * 2. 아직까지 저렇게 비교하는 부분이 머릿속에 제대로 박혀있지 않아서 그런 것 같다
     * 3. 로직의 순서를 못찾는 것을 봤을 때는 로직을 정리 못한 것 같다.
     * -
     * */
}