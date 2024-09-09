import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int[][] adjArr;
	static int V,E;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt(); // 정점 개수 
		E = sc.nextInt(); // 간선 개수
		
		adjArr = new int[V+1][V+1];
		visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = 1;
		}
		dfs(1);
		System.out.println(result-1);
	}

	private static void dfs(int idx) {
		result++;
		visited[idx] = true;
		
		for (int i = 1; i < adjArr.length; i++) {
			if(!visited[i] && adjArr[idx][i] == 1) {
				dfs(i);
			}
		}
	}
}
