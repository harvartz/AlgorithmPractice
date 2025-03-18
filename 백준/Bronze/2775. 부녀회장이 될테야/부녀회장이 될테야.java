import java.io.*;
import java.util.*;

class Main {

    static int[][] apt = new int[15][15];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        apt();
        for(int i = 0; i<T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
        }
    }

    // static int recur(int floor, int num){
    //     int sum = 0;

    //     if(floor == 0){
    //         apt[0][num] = num;
    //         return apt[0][num];
    //     }

    //     for(int i = 1; i <= num; i++){
    //         if(apt[floor][num] > 0){
    //             sum += apt[floor][num];
    //         }else{
    //             sum += recur(floor-1, i);
    //         }
    //     }

    //     return sum;
    // }

    public static void apt(){
        for(int i = 0; i<15; i++){
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for(int i = 1; i<15; i++){
            for(int j = 2; j<15; j++){

                // 1호는 항상 1로 고정
                // APT[i][j-1] = 구하는 층의 전 호수 갯수
                // apt[i-1][j] = 구하는 전 층의 지금 호수 갯수
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }
    }


}