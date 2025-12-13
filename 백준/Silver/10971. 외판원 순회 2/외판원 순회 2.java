import java.io.*;
import java.util.*;
public class Main{
    static int N,arr[][];
    static boolean visit[];
    static int result=Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1][N+1];
        visit=new boolean[N+1];
        
        for(int i=1; i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
      
        visit[1] = true;
        back(1,1,1,0);
        System.out.println(result);
        
    }
    
    static void back(int start, int now, int count, int cost){
        if(arr[now][start]!=0 && count==N){
            result = Math.min(result,cost+arr[now][start]);
            return;
        }
        for(int next=1;next<=N;next++){
            if(arr[now][next]>0&&!visit[next]){
                visit[next]=true;
                back(start, next, count+1, cost+arr[now][next]);
                visit[next] = false;
                
            }
        }
    }
}