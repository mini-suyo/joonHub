import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        sc.close();
        
        int result = 1;
        int lastNum = N-1;
        for (int i = lastNum - 1; i >= 0; i--) {
            if (arr[i] > arr[lastNum]) {
                lastNum = i;
                result ++;
            }
        }


        System.out.println(result);

    }
}
