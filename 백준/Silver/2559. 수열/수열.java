import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력부
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // 슬라이딩 윈도우
        int max = 0;

        // 처음 max 값 결정
        for (int i = 0; i < K; i++) {
            max += arr[i];
        }

        int tmp = max;

        for (int i = K; i < arr.length; i++) {
            tmp += arr[i];
            tmp -= arr[i - K];
            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);

    }
}
