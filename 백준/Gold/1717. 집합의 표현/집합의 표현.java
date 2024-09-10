import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 집합의 개수(0부터 N까지)
		M = sc.nextInt(); // 입력으로 주어지는 연산의 개수 
		arr  = new int[N+1]; //대표 노드가 나타나 있는 배열
		
		for (int i = 0; i < N+1; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i <M; i++) {
			int C = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(C == 0) {
				union(A,B);
			}else {
				if(findset(A)== findset(B)) {
					System.out.println("YES");
				}else 
					System.out.println("NO");
			}
		}

	}

	private static int findset(int a) {
		if(a != arr[a]) {
			arr[a] = findset(arr[a]);
		}return arr[a];
		
	}

	private static void union(int a, int b) {
		arr[findset(b)] = findset(a);
		
	}

}
