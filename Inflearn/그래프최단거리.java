import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 인프런 : 그래프 최단 거리
*
* */
public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static Queue<Integer> qu;
    static int[] dis;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new ArrayList<>();
        dis = new int[n];

        for (int x = 0; x < n; x++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
        }

        qu.offer(1);
        ch[1] = 1;
        dis[1] = 0;

        while (!qu.isEmpty()) {
            int input = qu.poll();
            for(int y : arr.get(input)){
                if(ch[input] == 0){
                    dis[arr.get(input).get(y)] = dis[input] + 1;
                    qu.add(arr.get(input).get(y));
                }
            }
        }
    }
}