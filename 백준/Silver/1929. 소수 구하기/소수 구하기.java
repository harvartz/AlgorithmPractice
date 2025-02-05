import java.util.Scanner;
public class Main {
    public static boolean[] prime;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        prime = new boolean[N+1];

        get_prime();

        for(int x = M; x<=N; x++){
            if(!prime[x]) System.out.println(x);
        }

    }

    public static void get_prime(){
        prime[0] = prime[1] = true;

        for(int x = 2; x< Math.sqrt(prime.length); x++){
            if(prime[x]) continue;
            for(int y = x*x; y< prime.length; y+=x){
                prime[y] = true;
            }
        }
    }
}