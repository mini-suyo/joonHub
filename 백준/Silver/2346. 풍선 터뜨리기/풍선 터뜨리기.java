import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offerLast(new int[]{i, sc.nextInt()});
        }
        sc.close();

        int[] cur = dq.pollFirst();
        System.out.print(cur[0]);

        while (!dq.isEmpty()) {
            int k = cur[1];

            if (k > 0) {
                for (int i = 0; i < k - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -k; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }

            cur = dq.pollFirst();
            System.out.print(" " + cur[0]);
        }
    }
}
