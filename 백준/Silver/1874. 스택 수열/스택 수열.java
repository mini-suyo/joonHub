import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        int current = 1;
        boolean possible = true;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();

            // target보다 작거나 같을 때까지 push
            while (current <= target) {
                stack.push(current++);
                result.add("+");
            }

            // target이랑 같으면 pop
            if (stack.peek() == target) {
                stack.pop();
                result.add("-");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
