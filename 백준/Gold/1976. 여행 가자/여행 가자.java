import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] adjArr; // 연결정보 입력받는 배열
	static int[] p; // 대표 노드 나타내는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //도시의 수 
		M = sc.nextInt(); //여행계획에 속한 도시의 수 
		
		adjArr = new int[N+1][N+1];
		p = new int[N+1];
		
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				adjArr[i][j] = sc.nextInt();
			}
		}
		
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				if(adjArr[r][c] == 1) {
					union(r,c);
				}
			}
		}
		int[] plan = new int[M]; // 여행계획 배열 
		boolean check = false;
        
		for (int i = 0; i < M; i++)  {
			plan[i] = sc.nextInt();
		}
		
		for (int i = 1; i < M; i++)  {
			if(findset(plan[i]) != findset(plan[i-1])) {
				System.out.println("NO");
				check = true;
				break;
			}
		}
		if(!check) System.out.println("YES");	
	}

	private static void union(int r, int c) {
		p[findset(c)] = findset(r);
		
	}

	private static int findset(int x) {
		if(x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	
	

}
