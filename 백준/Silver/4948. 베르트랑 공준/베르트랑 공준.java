import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inputs = new int[100000];
        int count = 0;

        for (int i = 0; i < inputs.length; i++) {
            int n = sc.nextInt();
            if (n == 0) break;
            inputs[count++] = n;
        }

        for (int i = 0; i < count; i++) {
            int n = inputs[i];
            int primeCount = 0;

            for (int j = n + 1; j <= 2 * n; j++) {
                boolean isPrime = true;

                if (j < 2) {
                    isPrime = false;
                } else {
                    for (int k = 2; k * k <= j; k++) {
                        if (j % k == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

                if (isPrime) {
                    primeCount++;
                }
            }

            System.out.println(primeCount);
        }

        sc.close();
    }
}
