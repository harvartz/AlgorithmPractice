import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        int ascend = 0;
        int descend = 0;
        for (int i = 1; i < 8; i++) {
            if (n[i - 1] < n[i]) {
                ascend++;
            } else if (n[i - 1] > n[i]) {
                descend++;
            }
        }

        if (ascend == 7) System.out.println("ascending");
        else if (descend == 7) System.out.println("descending");
        else System.out.println("mixed");
    }
}