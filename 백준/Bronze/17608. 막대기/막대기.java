import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // arr 배열에서 마지막 수보다 큰수를 역순으로 찾는다.
        // 찾을 때 마다 결과값을 1씩 증가 시키고 최댓값 변수로 저장한다.
        // 

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        sc.close();

        int max = arr[N-1];
        int result = 1;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                result++;
            }
        }


        System.out.println(result);

    }
}
