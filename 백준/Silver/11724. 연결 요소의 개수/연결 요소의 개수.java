import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 수
        int m = sc.nextInt(); // 간선 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int curr = stack.pop();
                    for (int next : graph.get(curr)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            stack.push(next);
                        }
                    }
                }

                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
