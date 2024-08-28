import java.util.Scanner;

public class Solution {
	static int[] arr, tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[1000000];
		tmp = new int[1000000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		mergeSort(0, arr.length - 1);
		System.out.println(arr[500000]);

	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}

	}

}
