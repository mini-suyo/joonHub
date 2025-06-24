import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) isBalanced = false;

            System.out.println(isBalanced ? "yes" : "no");
        }

        sc.close();
    }
}
