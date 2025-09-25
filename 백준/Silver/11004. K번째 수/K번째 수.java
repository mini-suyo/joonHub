import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int idx = 0; idx < n; idx++) arr[idx] = sc.nextInt();
        sc.close();

        int start = 0, end = n - 1;
        int kIndex = k - 1;

        while (true) {
            int pivot = arr[start + (end - start) / 2];
            int left = start, right = end;

            while (true) {
                while (left <= right && arr[left] < pivot) left++;
                while (left <= right && arr[right] > pivot) right--;
                if (left > right) break;
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }

            if (kIndex <= right) {
                end = right;
            } else if (kIndex >= left) {
                start = left;
            } else {
                System.out.print(arr[kIndex]);
                break;
            }
        }
    }
}
