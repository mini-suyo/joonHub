import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		String newS = "";

		// 문자나 라면 스택에 넣고 스페이스바라면 스택에있는것을 모두 pop
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ' ') {
				while (!stack.isEmpty()) {
					newS += stack.pop();
				}
				newS += S.charAt(i);
			} else if (S.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					newS += stack.pop();
				}
				int tmp = i;
				while (S.charAt(tmp) != '>') {
					newS += S.charAt(tmp);
					tmp++;
				}
				newS += '>';
				i = tmp;
				
			} else {
				stack.push(S.charAt(i));
			}

		}
		while (!stack.isEmpty()) {
			newS += stack.pop();

			// <를만나면 >를 만날때까지 그냥 출력(이중 for문 활용)

		}
		System.out.println(newS);
	}
}