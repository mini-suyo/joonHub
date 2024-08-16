import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int switch_number = sc.nextInt();

		int[] arr = new int[switch_number];

		for (int i = 0; i < switch_number; i++) {
			arr[i] = sc.nextInt();
		}

		int person = sc.nextInt();

		for (int i = 0; i < person; i++) {

			int sex = sc.nextInt();
			int number = sc.nextInt();

			if (sex == 1) {
				int k = 1;
				while (number * k <= arr.length) {
					if (arr[number * k - 1] == 0) {
						arr[number * k - 1] = 1;
					} else if (arr[number * k - 1] == 1) {
						arr[number * k - 1] = 0;
					}
					k++;
				}
			}

			if (sex == 2) {
				int k = 1;
				if(arr[number-1]==0) {
					arr[number-1]=1;
				}
				else {
					arr[number-1]=0;
				}
				while (number + k <= arr.length && number - k > 0) {
					if (arr[number - 1 - k] == arr[number - 1 + k] && arr[number - 1 - k] == 1) {
						arr[number - 1 - k] = 0;
						arr[number - 1 + k] = 0;
						k++;
					} else if (arr[number - 1 - k] == arr[number - 1 + k] && arr[number - 1 - k] == 0) {
						arr[number - 1 - k] = 1;
						arr[number - 1 + k] = 1;
						k++;
					} else {
						break;
					}
				}

			}

		}
		for(int result=0; result<arr.length; result++) {
			System.out.print(arr[result]+" ");
			if (result %20==19) {
				System.out.println();
			}
			}
		}

	}