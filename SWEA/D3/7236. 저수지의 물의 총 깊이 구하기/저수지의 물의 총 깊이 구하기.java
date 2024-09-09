import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); //구획 크기		
			String[][] arr = new String[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			int[] dr = new int[] {-1,1,0,0,-1,-1,1,1};
			int[] dc = new int[] {0,0,-1,1,-1,1,-1,1}; //상,하,좌,우,좌상,우상,좌하,우하
			int cnt = 0; // W개수 세는 변수
			int max = 0; // 최댓값 저장하는 변수
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					cnt = 0;
					if(arr[r][c].equals("W")) {
						for (int i = 0; i < dc.length; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];
							
							if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
								if(arr[nr][nc].equals("W")) {
									cnt++;
								}
							}
						}
						if(cnt > max) {
							max = cnt;
						}
					}
				}
			}
			if(max == 0) {
				max = 1;
			}
			System.out.println("#"+ tc+ " "+ max);
		}
	}
}
