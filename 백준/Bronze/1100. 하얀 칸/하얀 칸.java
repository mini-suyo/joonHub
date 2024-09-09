import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[8][8];
		
		for (int i = 0; i < map.length; i++) {
			String line = sc.next();
			for (int j = 0; j < map.length; j++) {
				map[i] = line.split("");
			}
		}
		int result = 0; //몇개 놓여있는지 저장하는 변수
		 
		for (int r = 0; r < map.length; r+=2) {
			for (int c = 0; c < map.length; c+=2) {
				if(map[r][c].equals("F")) {
					result++;
				}
			}
		}
		for (int r = 1; r < map.length; r+=2) {
			for (int c = 1; c < map.length; c+=2) {
				if(map[r][c].equals("F")) {
					result++;
				}
			}
		}
		
		System.out.println(result);
//		System.out.println(Arrays.deepToString(map));

	}

}
