import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(num);
            }
        }

        long sum = 0;
        for (int x : stack) {
            sum += x;
        }

        System.out.println(sum);
        sc.close();
    }
}
