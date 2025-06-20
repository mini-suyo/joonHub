import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > K) {
            int tmp = queue.poll();
            for (int i = 1; i < K; i++) {
                queue.poll();
            }
            queue.add(tmp);
        }

        System.out.print(queue.poll());

    }
}
