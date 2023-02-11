import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int x = 0; x<N; x++){
            System.out.println(check(sc.next()));
        }
    }

    public static String check(String s){
        Stack<Character> stack = new Stack<>();

        for(int x=0; x<s.length(); x++){
            char c = s.charAt(x);

            if(c == '('){
                stack.push(c);
            }
            else if(stack.empty()){
                return "NO";
            }
            else{
                stack.pop();
            }
        }
        if(stack.empty()){
            return "YES";
        }
        else {
            return "NO";
        }
    }

}
