import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;
            else {
                char[] arr = input.toCharArray();
                boolean flag = true;
                for (int i = 0; i < arr.length / 2; i++) {
                    if (arr[i] != arr[arr.length - 1 - i]) {
                        flag = false;
                        sb.append("no").append("\n");
                        break;
                    }
                }
                if (flag) sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}