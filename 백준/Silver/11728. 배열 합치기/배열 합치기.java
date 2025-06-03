import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력부
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();

        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> result = new ArrayList<>();

        // 투 포인터 정렬
        while (p1 < N && p2 < M) {
            if (arr1[p1] <= arr2[p2]) {
                result.add(arr1[p1++]);
            } else {
                result.add(arr2[p2++]);
            }
        }
        while (p1 < N) result.add(arr1[p1++]);
        while (p2 < M) result.add(arr2[p2++]);

        // 출력 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
