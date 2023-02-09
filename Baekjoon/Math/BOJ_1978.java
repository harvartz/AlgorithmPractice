import java.util.*;
public class Main {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for(int i = 0; i<N; i++){
            boolean isPrime = true;
            int Y = sc.nextInt();
            if(Y==1) {continue;}

            for(int j = 2; j<= Math.sqrt(Y); j++){
                if(Y%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {count++;}
        }
        System.out.print(count);
    }
}