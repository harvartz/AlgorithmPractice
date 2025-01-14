import java.io.*;
import java.util.*;

public class Main {

 static Long[] seq = new Long[101];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    seq[0] = 0L;
    seq[1] = 1L;
    seq[2] = 1L;
    seq[3] = 1L;

    int T = Integer.parseInt(br.readLine());

    while(T-- > 0 ){
      sb.append(recur(Integer.parseInt(br.readLine()))).append('\n');
    }
    System.out.println(sb);
  }

  public static long recur(int N){
    if(seq[N] == null){
      seq[N] = recur(N-2) + recur(N-3);
    }
    return seq[N];
  }

}