import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int notHear = Integer.parseInt(st.nextToken());
        int notSee = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> list = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (int x = 0; x < notHear; x++) {
            String input = br.readLine();
            list.put(input, list.getOrDefault(input, 0) + 1);
        }

        for (int x = 0; x < notSee; x++) {
            String input = br.readLine();
            if (list.containsKey(input)) {
                result.add(input);
            }
        }

        result.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String arr : result) {
            sb.append(arr).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}