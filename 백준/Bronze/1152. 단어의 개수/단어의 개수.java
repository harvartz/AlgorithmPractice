import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            if (st.hasMoreTokens()) {
                st.nextToken();
                count++;
            } else break;
        }
        System.out.println(count);
    }
}