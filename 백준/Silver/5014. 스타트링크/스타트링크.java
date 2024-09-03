import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int F, S, G, U, D;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); // 건물의 층 수
		S = sc.nextInt(); // 현재 내가 있는 층 수
		G = sc.nextInt(); // 도착해야하는 층 수
		U = sc.nextInt(); // 올라가는 층의 수
		D = sc.nextInt(); // 내려가는 층의 수
		visited = new int[F + 1];	// idx는 층 수, value는 방문횟수

		function();

	}

	static void function() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);	// 시작위치를 큐에 추가하고 시작
		visited[S] = 1;

		while (!queue.isEmpty()) {
			// 큐에서 현재 층을 꺼내고 C에 저장
			int C = queue.poll();
			
			// 현재 층이 목표일때
			if (C == G) {
				System.out.println(visited[C] - 1);	
				return;
			}
			
			// 위로 올라갔다
			if (C + U <= F && visited[C + U] == 0) {
				visited[C + U] = visited[C] + 1;
				queue.add(C + U);
			}
			
			// 아래로 내려갔다
			if (C - D > 0 && visited[C - D] == 0) {
				visited[C - D] = visited[C] + 1;
				queue.add(C - D);
			}

		}
		
		// 목표를 달성할수 없다..
		if (visited[G] == 0)
			System.out.println("use the stairs");

	}

}