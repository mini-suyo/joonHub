import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 오큰수 찾기 (역순 탐색)
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }

        // 결과 출력 (빠르게)
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
