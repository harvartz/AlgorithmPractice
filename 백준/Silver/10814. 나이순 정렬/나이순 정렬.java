import java.io.*;
import java.util.*;

class Main {

    static class User {
        int age;
        String name;
        int createdNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        User[] arr = new User[N];
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new User();
            arr[i].age = Integer.parseInt(st.nextToken());
            arr[i].name = st.nextToken();
            arr[i].createdNum = i;
        }

        // 숫자를 문자열로 받은 경우, int형으로 알아서 형변환이 가능할까?
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.age == o2.age) {
                return Integer.compare(o1.createdNum, o2.createdNum);
            }
            return Integer.compare(o1.age, o2.age);
        });

        for (User i : arr) {
            System.out.println(i.age + " " + i.name);
        }
    }
}