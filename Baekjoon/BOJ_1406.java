import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String str = br.readLine();
      Stack<Character> leftStack = new Stack<Character>();
      Stack<Character> rightStack = new Stack<Character>();

      //스택 초기화
      for(int x = 0; x<str.length(); x++){
         leftStack.push(str.charAt(x));
      }

      int N = Integer.parseInt(br.readLine());

      for(int y = 0; y<N ;y++ ){
         String input = br.readLine();
         switch(input.charAt(0)){
            case 'L':
               if(leftStack.empty()) break;
               rightStack.push(leftStack.pop());
               break;
            case 'D':
               if(rightStack.empty()) break;
               leftStack.push(rightStack.pop());
               break;
            case 'B':
               if(leftStack.empty()) break;
               leftStack.pop();
               break;
            case 'P':
               leftStack.push(input.charAt(2));
               break;
         }
      }
      while(!leftStack.empty()){
         rightStack.push(leftStack.pop());
      }
      StringBuilder sb = new StringBuilder();
      while(!rightStack.empty()){
         bw.write(rightStack.pop());
      }
      bw.flush();
      bw.close();
   }
}
