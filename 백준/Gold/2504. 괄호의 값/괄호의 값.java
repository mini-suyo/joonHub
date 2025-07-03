import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 스택을 써서 여는 괄호는 그대로 넣고, 닫는 괄호가 나오면 스택에서 값을 꺼내 계산
        // 계산된 값을 다시 스택에 넣고, 마지막에 남은 숫자들을 전부 더하면 result
        // 만약 중간에 괄호 짝이 안 맞거나 잘못된 형식이면 0을 출력

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Stack<Object> stack = new Stack<>();
        boolean isValid = true;

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                int value = 0;

                while (!stack.isEmpty()) {
                    Object top = stack.pop();

                    if (top instanceof Integer) {
                        value += (int) top;
                    } else {
                        char open = (char) top;

                        if ((ch == ')' && open == '(') || (ch == ']' && open == '[')) {
                            if (value == 0)
                                value = 1;
                            value *= (ch == ')') ? 2 : 3;
                            stack.push(value);
                            break;
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (!isValid || stack.isEmpty() && (ch == ')' || ch == ']')) {
                    isValid = false;
                    break;
                }
            }
        }

        int result = 0;
        if (isValid) {
            while (!stack.isEmpty()) {
                Object top = stack.pop();
                if (top instanceof Integer) {
                    result += (int) top;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        System.out.println(isValid ? result : 0);
    }
}
