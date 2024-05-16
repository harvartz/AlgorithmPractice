import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Main {

    static class xy {
        int x;
        int y;

        xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Map<Character, xy> s;
    static Map<Character, xy> v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = new HashMap<>(); // 자음
        v = new HashMap<>(); // 모음

        addMap();

        String input = br.readLine();
        char left = input.charAt(0);
        char right = input.charAt(2);
        int time = 0;

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char find = input.charAt(i);

            if (s.containsKey(find)) {
                time += Math.abs(s.get(find).x - s.get(left).x) + Math.abs(s.get(find).y - s.get(left).y) + 1;
                left = find;
            } else {
                time += Math.abs(v.get(find).x - v.get(right).x) + Math.abs(v.get(find).y - v.get(right).y) + 1;
                right = find;
            }
        }

        System.out.println(time);
    }

    private static void addMap() {
        s.put('q', new xy(1, 1));
        s.put('w', new xy(1, 2));
        s.put('e', new xy(1, 3));
        s.put('r', new xy(1, 4));
        s.put('t', new xy(1, 5));
        s.put('a', new xy(2, 1));
        s.put('s', new xy(2, 2));
        s.put('d', new xy(2, 3));
        s.put('f', new xy(2, 4));
        s.put('g', new xy(2, 5));
        s.put('z', new xy(3, 1));
        s.put('x', new xy(3, 2));
        s.put('c', new xy(3, 3));
        s.put('v', new xy(3, 4));

        v.put('y', new xy(1, 6));
        v.put('u', new xy(1, 7));
        v.put('i', new xy(1, 8));
        v.put('o', new xy(1, 9));
        v.put('p', new xy(1, 10));
        v.put('h', new xy(2, 6));
        v.put('j', new xy(2, 7));
        v.put('k', new xy(2, 8));
        v.put('l', new xy(2, 9));
        v.put('b', new xy(3, 5));
        v.put('n', new xy(3, 6));
        v.put('m', new xy(3, 7));
    }

}
