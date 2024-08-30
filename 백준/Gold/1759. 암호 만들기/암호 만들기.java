

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int l;
	static int c;
	static char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u' };
	static char[] array;
	static boolean[] visit; // array의 원소를 방문했는지 확인
	static char[] num;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		c = sc.nextInt();
		array = new char[c];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.next().charAt(0);
		}
		visit = new boolean[c];
		num = new char[l];
		Arrays.sort(array);
		dfs(0,0);

		//System.out.println(Arrays.toString(array));

	}

	static void dfs(int depth, int idx) {
		if (depth == l) {
			int conCount = 0; // 자음 개수
			int vowCount = 0; // 모음 개수
			for (int i = 0; i < num.length; i++) {
				boolean flag = true;
				for (int j = 0; j < vowel.length; j++) {
					if(vowel[j] == num[i]) {
						vowCount++;
						flag =false;
					}
				}
				if(flag)conCount++;
			}
			if (vowCount >= 1 && conCount >= 2) {
				for (int i = 0; i < num.length; i++) {
					System.out.print(num[i]);
				}
				System.out.println();
			}
			else return;
				

		} else {
			for (int i =0 ; i < array.length; i++) {
				if (depth == 0 || num[depth-1]<array[i]) {
					//visit[i] = true;
					
					num[depth++] = array[i];
					dfs(depth, idx+1);
					
					depth--;
					//visit[i] = false;
				}
			}
		}

	}

}
