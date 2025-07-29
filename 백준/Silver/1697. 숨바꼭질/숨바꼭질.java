import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int target = sc.nextInt();

        int max = 100000;
        int[] visited = new int[max + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                System.out.println(visited[current] - 1);
                return;
            }

            int[] nextMove = {current - 1, current + 1, current * 2};

            for (int next : nextMove) {
                if (next >= 0 && next <= max && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
