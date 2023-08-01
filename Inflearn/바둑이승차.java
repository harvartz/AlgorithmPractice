import java.util.Scanner;

public class Main {
    static int[] arr;
    static int n;
    static int ans;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];
        for(int x = 0; x<n; x++){
            arr[x] = sc.nextInt();
        }
        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int Level, int sum){
        if(sum > c) return ;
        if(Level == n){
            ans = Math.max(ans, sum);
        }else{
            dfs(Level+1, sum+arr[Level]);
            dfs(Level+1, sum);
        }
    }
}