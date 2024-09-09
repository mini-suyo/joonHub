import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		tcloop: for (int tc = 1; tc <= T; tc++) {
			int[][] map = new int[9][9];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			boolean check  = true; //스도쿠 맞는지 확인여부 
			
			for (int r = 0; r < map.length; r++) {
				
			HashSet<Integer> wideset = new HashSet<>();
			HashSet<Integer> verticalset = new HashSet<>();
			
				for (int c = 0; c < map.length; c++) {
					if(!wideset.add(map[r][c])) {
						check = false;
						System.out.println("#"+ tc + " "+ 0);
						continue tcloop;
					}
					
					if(!verticalset.add(map[c][r])) {
						System.out.println("#"+ tc + " "+ 0);
						check = false;
						continue tcloop;
					}
				}
			}
			
			HashSet<Integer> set = new HashSet<>();
			
			int col = 0;
			int row = 0;
			final int RANGE = 3;
			
			for (int i = 0; i <map.length; i++) {
				if(i % RANGE == 0 && i != 0) {
					row += RANGE;
					col = 0;
				}
				
				for (int j = row; j <row+RANGE; j++) {
					for (int k = col; k < col+RANGE; k++) {
						if(!set.add(map[j][k])) {
							check = false;
							System.out.println("#"+ tc + " "+ 0);
							continue tcloop;
					}
				}	
				}
				set = new HashSet<>();
				col+= RANGE;
			}
			if(check) {
				System.out.println("#"+tc+" "+ 1);
			}
		}

	}

}
